package com.br.plurismidia.easymonitor.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "database_configs")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DatabaseConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
