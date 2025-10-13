package com.example.bank.DTO.responseDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BalanceDepositResponseDTO {

    private String accountNumber;
    private double amount;
}
