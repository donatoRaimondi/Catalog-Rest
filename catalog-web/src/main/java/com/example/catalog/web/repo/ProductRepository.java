package com.example.catalog.web.repo;

import com.example.catalog.web.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
  List<ProductEntity> findByActiveTrue();
}

