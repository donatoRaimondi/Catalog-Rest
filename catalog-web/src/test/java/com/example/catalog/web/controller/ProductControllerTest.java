package com.example.catalog.web.controller;

import com.example.catalog.api.dto.ProductDto;
import com.example.catalog.web.service.ProductDbService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  ProductDbService productService;

  @Test
  void listProducts() throws Exception {
    given(productService.listActive())
        .willReturn(List.of(new ProductDto("p1", "Test product", true)));

    mockMvc.perform(get("/api/products"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value("p1"))
        .andExpect(jsonPath("$[0].name").value("Test product"))
        .andExpect(jsonPath("$[0].active").value(true));
  }
}
