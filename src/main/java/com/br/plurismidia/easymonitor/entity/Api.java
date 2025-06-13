package com.br.plurismidia.easymonitor.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "TB_API")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Api {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_API_ID")
    private Long id;

    @NotBlank(message = "O nome da API é obrigatório.")
    @Column(name = "CD_DS_NOME")
    private String nome;

    @NotBlank(message = "A URL da API é obrigatória.")
    @Column(name = "CD_DS_URL")
    private String url;
}
