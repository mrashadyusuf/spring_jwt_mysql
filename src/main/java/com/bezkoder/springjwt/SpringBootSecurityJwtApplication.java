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

	@Autowired
	private Environment env;

	@PostConstruct
	private void postConstruct() {
		System.out.println("POSTGRESQL_HOST: " + env.getProperty("POSTGRESQL_HOST"));
		System.out.println("POSTGRESQL_USERNAME: " + env.getProperty("POSTGRESQL_USERNAME"));
		System.out.println("POSTGRESQL_PASSWORD: " + env.getProperty("POSTGRESQL_PASSWORD"));
		System.out.println("name: " + env.getProperty("name"));
		System.out.println("POSTGRESQL_PORT: " + env.getProperty("POSTGRESQL_PORT"));
	}


}
