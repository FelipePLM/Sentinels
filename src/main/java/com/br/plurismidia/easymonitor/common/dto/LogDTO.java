package com.br.plurismidia.easymonitor.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para envio de logs de monitoramento")
public record LogDTO(
        @Schema(description = "Indicação de erro", example = "YES")
        String error,

        @Schema(description = "Mensagem do log")
        String message,

        @Schema(description = "Operação que gerou o log")
        String operation
) {}
