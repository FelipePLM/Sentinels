package com.github.felipeplm.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CDTB_DATABASE_CONFIG_DACO")
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
