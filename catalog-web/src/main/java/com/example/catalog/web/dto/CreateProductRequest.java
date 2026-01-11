package com.example.catalog.web.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateProductRequest(
    @NotBlank String name
) {}

