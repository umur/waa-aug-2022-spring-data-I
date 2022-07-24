package edu.miu.lab3springdata;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab3SpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab3SpringDataApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
