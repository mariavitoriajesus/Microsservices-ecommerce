package com.storefront.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI custmOpenAPI(){
        return new OpenAPI().info(
                new Info()
                        .title("Storefront API")
                        .version("1.0")
                        .description("API responsável pela criação e gerenciamento de pedidos e usuários.")
        );

    }
}
