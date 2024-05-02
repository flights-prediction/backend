package com.backend.aiplane.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Airseeker  Server API 명세서",
                description = "Airseeker  Server API 명세서",
                version = "v1"))
@Configuration
public class SwaggerConfig {
}