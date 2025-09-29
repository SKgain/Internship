package com.example.basicSpringPractice.DTO.requestDTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class ProductRequestDTO {
    @NotBlank(message = "Must provide a product name")
    private String name;

    @NotBlank(message = "Must provide the product description")
    @Size(min = 1, max = 100)
    private String description;

    @NotNull(message = "Must provide the product unit price")
    @Positive(message = "Product price must be greater than zero")
    private double unitPrice;

    @NotNull(message = "Must provide the product quantity")
    @Positive(message = "Product quantity must be greater than zero")
    private int quantity;

    @NotBlank(message = "Must provide a product type")
    private String type;
}
