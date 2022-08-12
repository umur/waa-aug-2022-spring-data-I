package com.example.waa_lab3;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

import java.beans.BeanProperty;

@SpringBootApplication
public class WaaLab3Application {

    public static void main(String[] args) {
        SpringApplication.run(WaaLab3Application.class, args);
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
