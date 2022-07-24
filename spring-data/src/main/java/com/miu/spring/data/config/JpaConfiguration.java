package com.miu.spring.data.config;

import com.miu.spring.data.service.ProductService;
import com.miu.spring.data.service.impl.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfiguration {
    @Bean
    public ProductService productService(){
        return new ProductServiceImpl();
    }
}
