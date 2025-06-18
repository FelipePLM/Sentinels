package com.br.plurismidia.easymonitor.producer;

import com.br.plurismidia.easymonitor.dto.LogDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class LogProducer {

    private final RabbitTemplate rabbitTemplate;

    public void publishLog(LogDTO LogDto) {
        rabbitTemplate.convertAndSend("exchange_prod","sendLogs", LogDto);
        log.info("LOG Enviado com sucesso = {}", LogDto);
    }
}