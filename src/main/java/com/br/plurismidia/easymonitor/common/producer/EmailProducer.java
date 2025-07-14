package com.br.plurismidia.easymonitor.common.producer;

import com.br.plurismidia.easymonitor.common.dto.EmailDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class EmailProducer {

    private final RabbitTemplate rabbitTemplate;

    /**
     * Envia mensagem de e-mail para a fila do RabbitMQ.
     * @param emailDTO Dados do e-mail a ser enviado
     */
    public void publishEmail(EmailDTO emailDTO) {
        rabbitTemplate.convertAndSend("exchange_prod", "sendEmail", emailDTO);
        log.info("Email enviado com sucesso: {}", emailDTO);
    }
}
