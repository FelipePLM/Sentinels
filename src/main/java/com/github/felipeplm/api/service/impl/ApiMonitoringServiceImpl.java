package com.github.felipeplm.api.service.impl;

import com.github.felipeplm.api.entity.MonitoredApi;
import com.github.felipeplm.api.repository.MonitoredApiRepository;
import com.github.felipeplm.api.service.ApiMonitoringService;
import com.github.felipeplm.database.entity.DatabaseMonitoringResult;
import com.github.felipeplm.database.repository.DatabaseMonitoringResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiMonitoringServiceImpl implements ApiMonitoringService {

    private final MonitoredApiRepository apiRepository;
    private final DatabaseMonitoringResultRepository resultRepository;
    private final WebClient webClient;

    /**
     * Executa o monitoramento de todas as APIs cadastradas, salvando o resultado no banco.
     */
    @Override
    public void monitorAllApis() {
        LocalDateTime now = LocalDateTime.now();

        resultRepository.deleteAll();

        List<MonitoredApi> apis = apiRepository.findAll();

        List<ApiStatus> statuses = Flux.fromIterable(apis)
                .flatMap(api -> checkApiStatus(api).map(status -> new ApiStatus(api, status)))
                .collectList()
                .block();

        saveResults(statuses, now);
    }

    /**
     * Realiza requisição HTTP GET e obtém o status da API.
     */
    private Mono<String> checkApiStatus(MonitoredApi api) {
        return webClient.get()
                .uri(api.getUrl())
                .retrieve()
                .toBodilessEntity()
                .map(response -> String.valueOf(response.getStatusCodeValue()))
                .onErrorResume(WebClientResponseException.class,
                        ex -> Mono.just(String.valueOf(ex.getRawStatusCode())))
                .onErrorReturn("0");
    }

    /**
     * Salva o resultado do monitoramento no banco.
     */
    private void saveResults(List<ApiStatus> statuses, LocalDateTime timestamp) {
        statuses.forEach(s -> {
            DatabaseMonitoringResult result = DatabaseMonitoringResult.builder()
                    .nameApi(s.api.getName())
                    .status(s.status)
                    .dateTime(timestamp)
                    .build();
            resultRepository.save(result);
        });
    }

    // CRUD de MonitoredApi

    @Override
    public List<MonitoredApi> findAll() {
        return apiRepository.findAll();
    }

    @Override
    public MonitoredApi save(MonitoredApi api) {
        return apiRepository.save(api);
    }

    @Override
    public MonitoredApi update(Long id, MonitoredApi updatedApi) {
        return apiRepository.findById(id).map(existingApi -> {
            existingApi.setName(updatedApi.getName());
            existingApi.setUrl(updatedApi.getUrl());
            return apiRepository.save(existingApi);
        }).orElseThrow(() -> new RuntimeException("API não encontrada com id: " + id));
    }

    @Override
    public void delete(Long id) {
        apiRepository.deleteById(id);
    }

    /**
     * Record interna para armazenar o status retornado de cada API
     */
    private record ApiStatus(MonitoredApi api, String status) {
    }
}
