package com.example.basicSpringPractice.controller;

import com.example.basicSpringPractice.DTO.requestDTO.OrderRequestDTO;
import com.example.basicSpringPractice.DTO.responseDTO.OrderResponseDTO;
import com.example.basicSpringPractice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/odres/all")
    public List<OrderResponseDTO> getAllOrders() {

        return orderService.getAllOrders();
    }

    @PostMapping("order/create")
    public ResponseEntity<String> createOrder(
            @RequestParam int customerID,
            @RequestParam List<Integer> productID,
            @RequestBody OrderRequestDTO dto
    ){
        return orderService.createOrder(customerID, productID, dto);
    }

    @DeleteMapping("/order/delete/{id}")
    public ResponseEntity<String> deleteOrder(
            @PathVariable int id
    ){
        return orderService.deleteOrder(id);
    }
}
