package com.square.rbc.apppropapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.square.rbc")
public class AppPropApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppPropApiApplication.class, args);
	}
}
