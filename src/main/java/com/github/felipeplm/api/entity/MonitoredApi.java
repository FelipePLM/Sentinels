package com.github.felipeplm.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "CDTB_API")
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
