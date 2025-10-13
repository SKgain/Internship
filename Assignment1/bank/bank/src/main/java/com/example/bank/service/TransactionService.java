package com.example.bank.service;

import com.example.bank.DTO.responseDTO.TransactionResponseDTO;
import com.example.bank.constant.AppConstant;
import com.example.bank.entity.Transaction;
import com.example.bank.entity.User;
import com.example.bank.repository.TransactionRepository;
import com.example.bank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public ResponseEntity<List<TransactionResponseDTO>> getAllTransaction(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException(AppConstant.USER_NOT_FOUND));
        List<Transaction> transaction = transactionRepository.findAllByUserId(user.getId());

        List<TransactionResponseDTO> transactionResponseDTOS = new ArrayList<>();
        for (Transaction transaction1 : transaction) {
            transactionResponseDTOS.add(modelMapper.map(transaction1, TransactionResponseDTO.class));
        }
        return ResponseEntity.ok(transactionResponseDTOS);
    }
}
