package com.github.felipeplm.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para envio de SMS")
public record SmsDTO(
        @Schema(description = "Número de telefone", example = "11999999999")
        String phoneNumber,

        @Schema(description = "Mensagem SMS")
        String message,

        @Schema(description = "Nome da operação ou origem do SMS")
        String operation
) {}
