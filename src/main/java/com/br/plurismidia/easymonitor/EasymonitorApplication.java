package com.br.plurismidia.easymonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EasymonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasymonitorApplication.class, args);
	}

}
