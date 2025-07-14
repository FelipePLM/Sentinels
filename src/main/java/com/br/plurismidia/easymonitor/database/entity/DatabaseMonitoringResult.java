package com.br.plurismidia.easymonitor.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "database_monitoring_result")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DatabaseMonitoringResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameApi;

    @Column(length = 2000)
    private String status;

    private LocalDateTime dateTime;
}
