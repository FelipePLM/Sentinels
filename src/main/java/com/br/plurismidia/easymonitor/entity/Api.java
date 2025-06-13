package com.br.plurismidia.easymonitor.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "CD_TB_API")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Api {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_id")
    private Long id;

    @NotBlank(message = "O nome da API é obrigatório.")
    @Column(name = "ds_nome")
    private String nome;

    @NotBlank(message = "A URL da API é obrigatória.")
    @Column(name = "ds_url")
    private String url;
}
