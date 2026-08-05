package com.github.felipeplm.common.producer;

import com.github.felipeplm.common.dto.SmsDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class SmsProducer {

    private final RabbitTemplate rabbitTemplate;

    /**
     * Envia mensagem SMS para a fila do RabbitMQ.
     * @param smsDTO Dados do SMS a ser enviado
     */
    public void publishSms(SmsDTO smsDTO) {
        rabbitTemplate.convertAndSend("exchange_prod", "sendSms", smsDTO);
        log.info("SMS enviado com sucesso: {}", smsDTO);
    }
}
