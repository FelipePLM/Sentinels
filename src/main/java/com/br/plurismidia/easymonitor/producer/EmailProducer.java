package com.br.plurismidia.easymonitor.producer;

import com.br.plurismidia.easymonitor.dto.EmailDTO;
import com.br.plurismidia.easymonitor.dto.LogDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class EmailProducer {
    private final RabbitTemplate rabbitTemplate;

    public void publishEmail(EmailDTO emailDTO) {
        rabbitTemplate.convertAndSend("exchange_prod","sendEmail", emailDTO);
        log.info("Email Enviado com sucesso = {}", emailDTO);
    }

}
