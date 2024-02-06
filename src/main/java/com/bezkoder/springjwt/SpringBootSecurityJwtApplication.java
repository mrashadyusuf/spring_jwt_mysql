package com.bezkoder.springjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringBootSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}

	// @Autowired
	// private Environment env;

	// @PostConstruct
	// private void postConstruct() {
	// 	System.out.println("MYSQL_HOST: " + env.getProperty("MYSQL_HOST"));
	// 	System.out.println("MYSQL_USERNAME: " + env.getProperty("MYSQL_USERNAME"));
	// 	System.out.println("MYSQL_PASSWORD: " + env.getProperty("MYSQL_PASSWORD"));
	// 	System.out.println("name: " + env.getProperty("name"));
	// }


}
