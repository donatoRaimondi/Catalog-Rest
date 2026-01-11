package com.example.catalog.service;

import com.example.catalog.api.dto.ProductDto;

import java.util.List;

public class ProductService {
  public List<ProductDto> listActive() {
    return List.of(
        new ProductDto("1", "Keyboard", true),
        new ProductDto("2", "Mouse", true)
    );
  }
}
