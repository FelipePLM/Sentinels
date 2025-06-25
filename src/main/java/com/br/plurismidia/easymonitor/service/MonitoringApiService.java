package com.br.plurismidia.easymonitor.service;

import com.br.plurismidia.easymonitor.dto.EmailDTO;
import com.br.plurismidia.easymonitor.dto.LogDTO;
import com.br.plurismidia.easymonitor.dto.SmsDTO;
import com.br.plurismidia.easymonitor.entity.Api;
import com.br.plurismidia.easymonitor.entity.MonitoringResult;
import com.br.plurismidia.easymonitor.producer.EmailProducer;
import com.br.plurismidia.easymonitor.producer.LogProducer;
import com.br.plurismidia.easymonitor.producer.SmsProducer;
import com.br.plurismidia.easymonitor.repository.ApiRepository;
import com.br.plurismidia.easymonitor.repository.MonitoringResultRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonitoringApiService {

    private static final String ALERT_EMAIL = "kauanmendes@plurismidia.com.br";
    private static final String ALERT_SMS_NUMBER = "11911703714";
    private static final String ALERT_SENDER_NAME = "Plurismidia";
    private static final String ALERT_SUBJECT = "🚨 Alerta de APIs com erro detectadas";

    private final ApiRepository apiRepository;
    private final MonitoringResultRepository resultRepository;
    private final EmailProducer emailProducer;
    private final SmsProducer smsProducer;
    private final LogProducer logProducer;
    private final WebClient webClient;

    public void monitorAllApis() {
        LocalDateTime now = LocalDateTime.now();

        // Limpa resultados antigos
        resultRepository.deleteAll();

        List<Api> apis = apiRepository.findAll();

        // Executa as verificações em paralelo
        List<ApiStatus> statuses = Flux.fromIterable(apis)
                .flatMap(api -> checkApiStatus(api).map(status -> new ApiStatus(api, status)))
                .collectList()
                .block();

        saveResults(statuses, now);

        List<ApiStatus> erroApis = statuses.stream()
                .filter(s -> !s.status.equals("200"))
                .toList();

        if (!erroApis.isEmpty()) {
            sendAlert(erroApis, now);
        }
    }

    private Mono<String> checkApiStatus(Api api) {
        return webClient.get()
                .uri(api.getUrl())
                .retrieve()
                .toBodilessEntity()
                .map(response -> String.valueOf(response.getStatusCodeValue()))
                .onErrorResume(WebClientResponseException.class, ex ->
                        Mono.just(String.valueOf(ex.getRawStatusCode())))
                .onErrorReturn("0");
    }

    private void saveResults(List<ApiStatus> statuses, LocalDateTime timestamp) {
        statuses.forEach(s -> {
            MonitoringResult result = MonitoringResult.builder()
                    .api(s.api)
                    .nameApi(s.api.getName())
                    .status(s.status)
                    .dateTime(timestamp)
                    .build();
            resultRepository.save(result);
        });
    }

    private void sendAlert(List<ApiStatus> erroApis, LocalDateTime timestamp) {
        StringBuilder mensagem = new StringBuilder();
        erroApis.forEach(apiStatus -> mensagem.append("API: ")
                .append(apiStatus.api.getName())
                .append(" | URL: ").append(apiStatus.api.getUrl())
                .append(" | Status: ").append(apiStatus.status)
                .append(" | Data/Hora: ").append(timestamp)
                .append("\n"));

        emailProducer.publishEmail(new EmailDTO(ALERT_EMAIL, ALERT_SUBJECT, mensagem.toString(), null, ALERT_SENDER_NAME));
        smsProducer.publishSms(new SmsDTO(ALERT_SMS_NUMBER, ALERT_SUBJECT, ALERT_SENDER_NAME));
        logProducer.publishLog(new LogDTO("YES", ALERT_SUBJECT + " " + mensagem.toString(), ALERT_SENDER_NAME));
    }

    private record ApiStatus(Api api, String status) {}
}
