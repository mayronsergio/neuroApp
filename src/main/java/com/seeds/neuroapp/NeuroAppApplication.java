package com.seeds.neuroapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
public class NeuroAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeuroAppApplication.class, args);
	}

}
