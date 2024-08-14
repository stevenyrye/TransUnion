package com.transunion.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

// Swagger URL: http://localhost:8080/swagger-ui.html
// In Mem DB console: http://localhost:8080/h2-console

@SpringBootApplication
@ComponentScan(basePackages = { "com.transunion.homework.*" })
@EnableScheduling
@EnableAsync
@ComponentScan(value = { "com.transunion.homework.*" })
public class TransUnionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransUnionApplication.class, args);
	}

}
