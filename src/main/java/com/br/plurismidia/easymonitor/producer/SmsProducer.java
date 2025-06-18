package com.br.plurismidia.easymonitor.producer;

import com.br.plurismidia.easymonitor.dto.SmsDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class SmsProducer {

    private final RabbitTemplate rabbitTemplate;

    public void publishSms(SmsDTO smsDTO) {
        rabbitTemplate.convertAndSend("exchange_prod","sendSms", smsDTO);
        log.info("SMS Enviado com sucesso = {}", smsDTO);
    }

}
