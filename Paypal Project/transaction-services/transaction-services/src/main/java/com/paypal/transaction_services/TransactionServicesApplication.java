package com.paypal.transaction_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
public class TransactionServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionServicesApplication.class, args);

		System.out.println("Hello");
	}

}
