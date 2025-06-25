package com.br.plurismidia.easymonitor.bean.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_MONITORING_RESULT_MORE")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class MonitoringResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_MONITORING_ID")
    private Long id;

    @Column(name = "CD_MONITORING_STATUS")
    private String status;

    @Column(name = "CD_MONITORING_DH_REGISTER")
    private LocalDateTime dateTime;

    @Column(name = "CD_MONITORING_DS_NAME")
    private String nameApi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_API_ID")
    private Api api;

}
