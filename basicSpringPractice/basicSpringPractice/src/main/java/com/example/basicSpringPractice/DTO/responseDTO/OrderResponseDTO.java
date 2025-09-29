package com.example.basicSpringPractice.DTO.responseDTO;

import com.example.basicSpringPractice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderResponseDTO {

    private int orderId;
    private String customerName;
    private String customerPhone;
    private List<Product> products;
}
