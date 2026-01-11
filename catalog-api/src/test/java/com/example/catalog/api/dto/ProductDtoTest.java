package com.example.catalog.api.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductDtoTest {
  @Test void createsRecord() {
    var p = new ProductDto("1", "Keyboard", true);
    assertEquals("Keyboard", p.name());
  }
}
