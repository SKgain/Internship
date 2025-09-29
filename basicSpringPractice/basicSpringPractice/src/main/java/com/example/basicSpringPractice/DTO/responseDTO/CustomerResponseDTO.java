package com.example.basicSpringPractice.DTO.responseDTO;

import com.example.basicSpringPractice.entity.Order;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDTO {
    private String name;
    private String email;
    private String phone;
    private String address;
    private int age;
    private List<Order> orders;

}
