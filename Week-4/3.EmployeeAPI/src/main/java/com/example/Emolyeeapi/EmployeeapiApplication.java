package com.example.Emolyeeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:employee.xml")
public class EmployeeapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeapiApplication.class, args);
	}

}
