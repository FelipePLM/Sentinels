package com.br.plurismidia.easymonitor.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "TB_API")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MonitoredApi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "API name is required")
    private String name;

    @NotBlank(message = "API URL is required")
    private String url;
}
