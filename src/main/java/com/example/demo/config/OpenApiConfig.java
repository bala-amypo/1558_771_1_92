package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger. v3.oas.models. info.Info;
import io. swagger.v3.oas. models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server();
        server.setUrl("/");
        server.setDescription("Current Server");
        
        return new OpenAPI()
                .info(new Info()
                        . title("Crime Analysis System API")
                        .version("1.0")
                        .description("API for Crime Analysis and Pattern Detection System"))
                .servers(List.of(server))
                .components(new Components()
                        .addSecuritySchemes("Bearer Authentication",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        . description("Enter JWT token")));
    }
}