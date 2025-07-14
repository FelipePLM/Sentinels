package com.br.plurismidia.easymonitor.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    /**
     * http://localhost:8080/swagger-ui.html
     * Ou
     * http://localhost:8080/swagger-ui/index.html
     */

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("EasyMonitor API")
                        .version("1.0")
                        .description("Documentação da API do EasyMonitor"));
    }
}
