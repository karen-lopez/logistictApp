package com.kl.logisticts.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class LogistictsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogistictsApplication.class, args);
	}

}
