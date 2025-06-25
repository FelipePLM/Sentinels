package com.br.plurismidia.easymonitor.bean.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_MONITORING_RESULT_MORE")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
@Schema(description = "Representa o resultado do monitoramento de uma API")
public class MonitoringResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_MONITORING_ID")
    @Schema(description = "Identificador único do resultado do monitoramento", example = "1")
    private Long id;

    @Column(name = "CD_MONITORING_STATUS")
    @Schema(description = "Status HTTP ou código retornado pela API monitorada", example = "200")
    private String status;

    @Column(name = "CD_MONITORING_DH_REGISTER")
    @Schema(description = "Data e hora do registro do resultado", example = "2025-06-25T14:30:00")
    private LocalDateTime dateTime;

    @Column(name = "CD_MONITORING_DS_NAME")
    @Schema(description = "Nome da API monitorada", example = "API Clientes")
    private String nameApi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_API_ID")
    @Schema(description = "API associada a este resultado")
    private Api api;
}
