package com.example.catalog.web.controller;

import com.example.catalog.api.dto.ProductDto;
import com.example.catalog.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public List<ProductDto> list() {
    return productService.listActive();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> getById(@PathVariable("id") String id) {
    return productService.listActive().stream()
      .filter(p -> p.id().equals(id))
      .findFirst()
      .map(ResponseEntity::ok)
      .orElseGet(() -> ResponseEntity.notFound().build());
  }
}

