package com.br.plurismidia.easymonitor.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CDTB_MONITORING_QUERY_MOQU")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DatabaseMonitoringQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jdbcTemplateName;

    private String description;

    @Column(length = 2000)
    private String sqlQuery;
}
