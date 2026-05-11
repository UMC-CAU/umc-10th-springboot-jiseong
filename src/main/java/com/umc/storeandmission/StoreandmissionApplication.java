package com.umc.storeandmission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StoreandmissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreandmissionApplication.class, args);
	}

}
