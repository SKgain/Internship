package com.example.basicSpringPractice.DTO.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDT0 {
    private String name;
    private String description;
    private Double price;
    private int quantity;
    private String type;
}
