package com.speedroller.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class V1Application {

	public static void main(String[] args) {
		SpringApplication.run(V1Application.class, args);
		System.out.println("Aplicación iniciada correctamente.");
		System.out.println("Visita http://localhost:8080 para acceder a la aplicación.");
	}

}
