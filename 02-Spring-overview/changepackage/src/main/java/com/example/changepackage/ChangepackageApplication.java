package com.example.changepackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "funController")
public class ChangepackageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChangepackageApplication.class, args);
	}

}
