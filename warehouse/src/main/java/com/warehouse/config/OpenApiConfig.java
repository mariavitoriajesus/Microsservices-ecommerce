package com.warehouse.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI wharehouseOpenAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("Warehouse API")
                        .version("1.0")
                        .description("API responsável pela gestão de produtos e estoque.")
        );
    }
}
