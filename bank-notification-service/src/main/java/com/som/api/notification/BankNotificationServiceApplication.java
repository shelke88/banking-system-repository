package com.som.api.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * @EnableFeignClients
 */public class BankNotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankNotificationServiceApplication.class, args);
	}

}
