package com.example.taskservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class TaskServiceApplication {
	
	@Bean
	public WebClient webClient() {
		return WebClient.builder().build(); 
	}
	

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}	
	public static void main(String[] args) {
		SpringApplication.run(TaskServiceApplication.class, args);
	}

}
