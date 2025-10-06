package com.example.basicSpringPractice.service;

import com.example.basicSpringPractice.DTO.requestDTO.OrderRequestDTO;
import com.example.basicSpringPractice.DTO.responseDTO.OrderResponseDTO;
import com.example.basicSpringPractice.entity.Order;
import com.example.basicSpringPractice.entity.Product;
import com.example.basicSpringPractice.exception.ResourceNotFoundException;
import com.example.basicSpringPractice.repository.CustomerRepository;
import com.example.basicSpringPractice.repository.OrderRepository;
import com.example.basicSpringPractice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public List<OrderResponseDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponseDTO> orderResponseDTOS = new ArrayList<>();
        for (Order order : orders) {
            orderResponseDTOS.add(modelMapper.map(order, OrderResponseDTO.class));
        }
        return orderResponseDTOS;
    }

    public ResponseEntity<String> createOrder(int customerID, List<Integer> productID, OrderRequestDTO dto) {
        Order order = new Order();
        order.setCustomer(customerRepository.findById(customerID).orElseThrow(() -> new ResourceNotFoundException("Customer not found!")));
        List<Product> orderedProductList = new ArrayList<>();
        for (Integer id : productID) {
            Product orderedProduct = productRepository.findById(id)
                    .orElseThrow(() -> {
                        log.error("Product not found with id={}", id);
                        return new ResourceNotFoundException("Product not found!");
                    });

            if (orderedProduct.getQuantity() < dto.getQuantity()) {
                log.debug("Available product: {} | Ordered quantity: {}",
                        orderedProduct.getQuantity(),
                        dto.getQuantity());
                throw new ResourceNotFoundException("Available product: " + orderedProduct.getQuantity());
            }
            orderedProduct.setQuantity(orderedProduct.getQuantity() - dto.getQuantity());
            orderedProductList.add(orderedProduct);
        }
        order.setProducts(orderedProductList);

        orderRepository.save(order);
        return ResponseEntity.ok().body("Order created");
    }

    public ResponseEntity<String> deleteOrder(int id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found!"));
        orderRepository.delete(order);
        return ResponseEntity.ok().body("Order deleted");
    }
}
