package com.pahanaedu.billingsystem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BillingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingSystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner testConnection(EntityManager entityManager) {
		return args -> {
			Query query = entityManager.createNativeQuery("SELECT 1");
			Object result = query.getSingleResult();
			System.out.println("✅ Database is connected. Test result: " + result);
		};
	}

}
