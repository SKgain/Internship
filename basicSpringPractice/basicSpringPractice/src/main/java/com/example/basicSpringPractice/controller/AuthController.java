package com.example.basicSpringPractice.controller;

import com.example.basicSpringPractice.DTO.requestDTO.LoginRequestDTO;
import com.example.basicSpringPractice.DTO.requestDTO.RegistrationRequestDTO;
import com.example.basicSpringPractice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AuthController {
    private final CustomerService customerService;

    @PostMapping("/registration")
    public ResponseEntity<String> customerRegistration(
            @Valid @RequestBody RegistrationRequestDTO dto
    ){
        return customerService.customerRegistration(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> customerLogin(
            @Valid @RequestBody LoginRequestDTO dto
    ){
        return customerService.customerLogin(dto);
    }
}
