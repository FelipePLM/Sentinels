package com.br.plurismidia.easymonitor.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "monitoring_query")
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
