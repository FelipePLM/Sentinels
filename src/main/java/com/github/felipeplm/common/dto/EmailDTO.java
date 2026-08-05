package com.github.felipeplm.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para envio de e-mails")
public record EmailDTO(
        @Schema(description = "Destinatário do e-mail", example = "usuario@empresa.com")
        String recipient,

        @Schema(description = "Assunto do e-mail", example = "Alerta de Erro")
        String subject,

        @Schema(description = "Conteúdo do e-mail")
        String messageContent,

        String link,
        String operation
) {}
