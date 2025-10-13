package com.example.bank.controller;


import com.example.bank.DTO.requestDTO.BalanceDepositRequestDTO;
import com.example.bank.DTO.requestDTO.BalanceTransferRequestDTO;
import com.example.bank.DTO.responseDTO.BalanceDepositResponseDTO;
import com.example.bank.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/init")
    public BalanceDepositResponseDTO initAccountBalance(Authentication authentication) {
        String email = authentication.getName();
        return
                accountService.initAccountBalance(email);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/deposit")
    public BalanceDepositResponseDTO depositAccountBalance(
            Authentication authentication,
            @Valid @RequestBody BalanceDepositRequestDTO balanceDepositRequestDTO
    ) {
        String email = authentication.getName();
        return
                accountService.depositAccountBalance(email, balanceDepositRequestDTO);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/transfer")
    public ResponseEntity<?> transferAccountBalance(
            Authentication authentication,
            @Valid @RequestBody BalanceTransferRequestDTO balanceTransferRequestDTO
    ) {
        String email = authentication.getName();
        return
                accountService.transferAccountBalance(email, balanceTransferRequestDTO);
    }
}
