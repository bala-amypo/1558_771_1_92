package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger. v3.oas.models. info.Info;
import io. swagger.v3.oas. models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        Server localServer = new Server();
        localServer.setUrl("http://localhost:9001");
        localServer.setDescription("Local Development Server");
        
        Server proxyServer = new Server();
        proxyServer.setUrl("https://5395e00f0cb2-8163.pro604cr. amypo.ai/proxy/9001");
        proxyServer.setDescription("Proxy Server");
        
        return new OpenAPI()
                .info(new Info()
                        . title("Crime Analysis System API")
                        .version("1.0")
                        . description("API for Crime Analysis and Pattern Detection System"))
                .servers(List.of(localServer, proxyServer))
                .components(new Components()
                        .addSecuritySchemes("Bearer Authentication",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        . description("Enter JWT token")));
    }
}