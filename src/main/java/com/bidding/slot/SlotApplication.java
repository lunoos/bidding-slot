package com.bidding.slot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SlotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlotApplication.class, args);
	}

}
