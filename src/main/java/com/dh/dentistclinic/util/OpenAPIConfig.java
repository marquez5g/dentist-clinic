package com.dh.dentistclinic.util;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Dentists Clinic API")
                        .version("0.0.1")
                        .description("A RESTful API to manage dentist appointments with users and patients. " +
                                "Spring Web, Spring JPA, H2, Hibernate and Lombok were used on this project.")
                );
    }
}
