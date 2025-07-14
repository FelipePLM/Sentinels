package com.br.plurismidia.easymonitor.common.producer;

import com.br.plurismidia.easymonitor.common.dto.LogDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class LogProducer {

    private final RabbitTemplate rabbitTemplate;

    /**
     * Publica um log na fila do RabbitMQ.
     * @param logDto DTO contendo dados do log
     */
    public void publishLog(LogDTO logDto) {
        rabbitTemplate.convertAndSend("exchange_prod", "sendLogs", logDto);
        log.info("Log enviado com sucesso: {}", logDto);
    }
}
