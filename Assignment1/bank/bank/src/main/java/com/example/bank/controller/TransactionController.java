package com.example.bank.controller;

import com.example.bank.DTO.responseDTO.TransactionResponseDTO;
import com.example.bank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/transactions")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {
    private final TransactionService transactionService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> getAllTransactions(
            Authentication authentication
    ) {
        String email = authentication.getName();
        return
                transactionService.getAllTransaction(email);
    }
}
