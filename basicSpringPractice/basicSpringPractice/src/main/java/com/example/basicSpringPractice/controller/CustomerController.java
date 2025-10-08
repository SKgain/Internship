package com.example.basicSpringPractice.controller;

import com.example.basicSpringPractice.DTO.requestDTO.UpdateCustomerProfileRequestDTO;
import com.example.basicSpringPractice.DTO.responseDTO.CustomerResponseDTO;
import com.example.basicSpringPractice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class    CustomerController {
    private final CustomerService customerService;

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/user/customer")
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers(){
        return customerService.getAllCustomer();
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/user/customer/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomer(
            @PathVariable int id
    ) {
        return customerService.getCustomer(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/customer/grater-then-age")
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomersWithAge(@RequestParam int age){
        return customerService.getAllCustomersWithAge(age);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/customer/ordered-by-age")
    public ResponseEntity<List<CustomerResponseDTO>> getCustomerOrderByAg(){
        return customerService.getCustomerOrderByAge();
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PutMapping("/user/customer/update-profile/{id}")
    public ResponseEntity<?> updateProfile(
            @PathVariable int id,
            @Valid @RequestBody UpdateCustomerProfileRequestDTO dto
    ){
        return customerService.updateProfile(id,dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/admin/customer/delete/{id}")
    public ResponseEntity<String> deleteCustomer(
            @PathVariable int id
    ){
        return customerService.deleteCustomer(id);
    }

}
