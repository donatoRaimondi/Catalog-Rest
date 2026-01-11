package com.example.catalog.web.config;

import com.example.catalog.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

  @Bean
  ProductService productService() {
    return new ProductService();
  }
}

