package com.project.EmailMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.Project.*")
public class EmailMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailMicroServiceApplication.class, args);
	}

}
