package com.example.catalog.app;

import com.example.catalog.service.ProductService;

public class Main {
  public static void main(String[] args) {
    var service = new ProductService();
    System.out.println(service.listActive());
  }
}

