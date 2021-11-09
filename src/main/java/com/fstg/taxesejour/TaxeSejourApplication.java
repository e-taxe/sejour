package com.fstg.taxesejour;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
public class TaxeSejourApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxeSejourApplication.class, args);
	}



}
