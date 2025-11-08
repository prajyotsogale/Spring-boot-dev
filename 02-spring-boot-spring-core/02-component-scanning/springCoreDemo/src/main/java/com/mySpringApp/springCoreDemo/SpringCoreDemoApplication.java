package com.mySpringApp.springCoreDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//tell explicitly to scan
/*@SpringBootApplication(
		scanBasePackages = {"com.mySpringApp.Util","com.mySpringApp.springCoreDemo"}
)*/
@SpringBootApplication
public class SpringCoreDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreDemoApplication.class, args);
	}

}
