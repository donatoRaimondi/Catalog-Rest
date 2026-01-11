package com.example.catalog.web.service;

import com.example.catalog.api.dto.ProductDto;
import com.example.catalog.web.entity.ProductEntity;
import com.example.catalog.web.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductDbService {

  private final ProductRepository repo;

  public ProductDbService(ProductRepository repo) {
    this.repo = repo;
  }

  public java.util.List<ProductDto> listActive() {
    return repo.findByActiveTrue().stream()
        .map(e -> new ProductDto(e.getId(), e.getName(), e.isActive()))
        .toList();
  }

  public java.util.Optional<ProductDto> getById(String id) {
    return repo.findById(id)
        .map(e -> new ProductDto(e.getId(), e.getName(), e.isActive()));
  }

  public ProductDto create(String name) {
    var e = new ProductEntity(UUID.randomUUID().toString(), name, true);
    repo.save(e);
    return new ProductDto(e.getId(), e.getName(), e.isActive());
  }
}

