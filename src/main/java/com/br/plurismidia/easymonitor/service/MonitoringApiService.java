package com.br.plurismidia.easymonitor.service;

import com.br.plurismidia.easymonitor.email.service.EmailService;
import com.br.plurismidia.easymonitor.entity.Api;
import com.br.plurismidia.easymonitor.entity.MonitoringResult;
import com.br.plurismidia.easymonitor.repository.ApiRepository;
import com.br.plurismidia.easymonitor.repository.MonitoringResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MonitoringApiService {

    private final ApiRepository apiRepo;
    private final MonitoringResultRepository resultadoRepo;
    private final RestTemplate restTemplate = new RestTemplate();
    private final EmailService emailService;

    public void monitorAllApis() {
        var apis = apiRepo.findAll();
        resultadoRepo.deleteAll();

        StringBuilder tabelaErro = new StringBuilder();
        boolean encontrouErro = false;

        for (Api api : apis) {
            String status;

            try {
                ResponseEntity<String> resposta = restTemplate.getForEntity(api.getUrl(), String.class);

                if (resposta.getStatusCode() == HttpStatus.OK && resposta.getBody() != null) {
                    String corpoResposta = resposta.getBody().toLowerCase();
                    status = corpoResposta.contains("\"status\":\"up\"") ? "UP" : "DOWN";
                } else {
                    status = "DOWN";
                    encontrouErro = true;
                }

            } catch (Exception e) {
                status = "ERRO";
                encontrouErro = true;
            }

            if (!status.equals("UP")) {
                tabelaErro.append("<tr>")
                        .append("<td>").append(api.getName()).append("</td>")
                        .append("<td>").append(api.getUrl()).append("</td>")
                        .append("<td>").append(LocalDateTime.now()).append("</td>")
                        .append("<td>").append(status).append("</td>")
                        .append("</tr>");
            }

            resultadoRepo.save(MonitoringResult.builder()
                    .api(api)
                    .nameApi(api.getName())
                    .status(status)
                    .dateTime(LocalDateTime.now())
                    .build());
        }

        if (encontrouErro) {
            String destinatario = "luislima@plurismidia.com.br";
            String assunto = "🚨 Alerta de APIs com erro detectadas";
            String mensagem = tabelaErro.toString();

            emailService.sendEmailReport(destinatario, assunto, mensagem);

        }
    }
}
