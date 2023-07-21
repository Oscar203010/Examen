package com.Gonzales.Infraccion_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InfraccionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfraccionServiceApplication.class, args);
	}

}
