package com.example.catalog.web.controller;

import com.example.catalog.api.dto.ProductDto;
import com.example.catalog.web.dto.CreateProductRequest;
import com.example.catalog.web.service.ProductDbService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  private final ProductDbService productService;

  public ProductController(ProductDbService productService) {
    this.productService = productService;
  }

  @GetMapping
  public List<ProductDto> list() {
    return productService.listActive();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> getById(@PathVariable("id") String id) {
    return productService.getById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ProductDto create(@Valid @RequestBody CreateProductRequest req) {
    return productService.create(req.name());
  }
}

