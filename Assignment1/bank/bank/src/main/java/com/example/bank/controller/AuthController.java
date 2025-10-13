package com.example.bank.controller;

import com.example.bank.DTO.requestDTO.SignInRequestDTO;
import com.example.bank.DTO.requestDTO.SignUpRequestDTO;
import com.example.bank.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(
            @Valid @RequestBody SignUpRequestDTO signUpRequestDTO
    ) {
        log.info("SignUpRequestDTO : {}", signUpRequestDTO.getEmail());
        return ResponseEntity
                .ok()
                .body(userService.signUp(signUpRequestDTO));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(
            @Valid @RequestBody SignInRequestDTO signInRequestDTO
    ) {
        log.info("SignInRequestDTO : {}", signInRequestDTO.getEmail());
        return ResponseEntity
                .ok()
                .body(userService.signIn(signInRequestDTO));
    }
}
