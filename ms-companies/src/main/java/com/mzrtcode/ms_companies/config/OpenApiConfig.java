package com.mzrtcode.ms_companies.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Microservicio Companies",
                version = "10.0.0",
                description = "This is a microservice to handle companies"
        )
)
public class OpenApiConfig {

}
