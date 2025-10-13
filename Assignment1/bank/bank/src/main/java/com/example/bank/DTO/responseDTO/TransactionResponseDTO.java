package com.example.bank.DTO.responseDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionResponseDTO {
    private String fromAccountNumber;
    private String toAccountNumber;
    private double amount;
    private String transactionID;
    private String date;
}
