package com.br.plurismidia.easymonitor.bean.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "TB_API")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
@Schema(description = "Entidade que representa uma API monitorada")
public class Api {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único da API", example = "1")
    private Long id;

    @NotBlank(message = "O nome da API é obrigatório.")
    @Schema(description = "Nome da API monitorada", example = "API Clientes")
    private String name;

    @NotBlank(message = "A URL da API é obrigatória.")
    @Schema(description = "URL da API", example = "https://api.meusite.com/clientes")
    private String url;
}
