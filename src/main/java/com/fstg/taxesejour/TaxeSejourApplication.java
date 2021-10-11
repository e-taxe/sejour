package com.fstg.taxesejour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TaxeSejourApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxeSejourApplication.class, args);
	}


}
