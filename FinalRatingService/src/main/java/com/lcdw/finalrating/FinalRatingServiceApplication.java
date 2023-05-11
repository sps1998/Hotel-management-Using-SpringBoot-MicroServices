package com.lcdw.finalrating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FinalRatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalRatingServiceApplication.class, args);
	}

}
