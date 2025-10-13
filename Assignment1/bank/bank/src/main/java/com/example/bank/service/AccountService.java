package com.example.bank.service;

import com.example.bank.DTO.requestDTO.BalanceDepositRequestDTO;
import com.example.bank.DTO.requestDTO.BalanceTransferRequestDTO;
import com.example.bank.DTO.responseDTO.BalanceDepositResponseDTO;
import com.example.bank.constant.AppConstant;
import com.example.bank.entity.Account;
import com.example.bank.entity.Transaction;
import com.example.bank.entity.User;
import com.example.bank.exception.DuplicateResourceException;
import com.example.bank.exception.InsufficientBalanceException;
import com.example.bank.exception.ResourceNotFoundException;
import com.example.bank.repository.AccountRepository;
import com.example.bank.repository.TransactionRepository;
import com.example.bank.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public BalanceDepositResponseDTO initAccountBalance(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException(AppConstant.USER_NOT_FOUND));
        Account account = accountRepository.findByUserId(user.getId());

        if (account.getAmount() == null) {
            account.setAmount(BigDecimal.ZERO);
            accountRepository.save(account);
        }
        return
                modelMapper.map(account, BalanceDepositResponseDTO.class);
    }

    @Transactional
    public BalanceDepositResponseDTO depositAccountBalance(
            String email,
            @Valid BalanceDepositRequestDTO balanceDepositRequestDTO
    ) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException(AppConstant.USER_NOT_FOUND));
        Account account = accountRepository.findByUserId(user.getId());

        BigDecimal depositAmount = balanceDepositRequestDTO.getAmount();
        BigDecimal initialBalance = account.getAmount();
        BigDecimal finalBalance = initialBalance.add(depositAmount);

        account.setAmount(finalBalance);

        log.info("final balance is {}", finalBalance);
        accountRepository.save(account);

        return
                modelMapper.map(account, BalanceDepositResponseDTO.class);
    }

    @Transactional
    public ResponseEntity<?> transferAccountBalance(
            String email,
            @Valid BalanceTransferRequestDTO balanceTransferRequestDTO
    ) {

        User fromUser = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(AppConstant.USER_NOT_FOUND));

        Account fromAccount = accountRepository.findByUserId(fromUser.getId());


        BigDecimal initialBalanceOfFromAccount =
                fromAccount.getAmount() != null ? fromAccount.getAmount() : BigDecimal.ZERO;

        BigDecimal transferAmount =
                balanceTransferRequestDTO.getAmount() != null ? balanceTransferRequestDTO.getAmount() : BigDecimal.ZERO;

        String toAccountNumber = balanceTransferRequestDTO.getToAccountNumber();


        if (initialBalanceOfFromAccount.compareTo(transferAmount) < 0) {
            throw new InsufficientBalanceException(AppConstant.INSUFFICIENT_BALANCE);
        }

        if (fromAccount.getAccountNumber().equals(toAccountNumber)) {
            throw new DuplicateResourceException(AppConstant.SAME_SENDER_AND_RECEIVER);
        }


        Account toAccount = accountRepository
                .findByAccountNumber(toAccountNumber)
                .orElseThrow(() -> new ResourceNotFoundException(AppConstant.ACCOUNT_NOT_FOUND));

        BigDecimal initialBalanceOfToAccount =
                toAccount.getAmount() != null ? toAccount.getAmount() : BigDecimal.ZERO;


        toAccount.setAmount(initialBalanceOfToAccount.add(transferAmount));
        fromAccount.setAmount(initialBalanceOfFromAccount.subtract(transferAmount));

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);


        Transaction transaction = new Transaction();
        transaction.setToAccountNumber(toAccountNumber);
        transaction.setFromAccountNumber(fromAccount.getAccountNumber());
        transaction.setAmount(transferAmount);
        transaction.setDate(LocalDateTime.now());
        transaction.setTransactionID(generateTransactionID());
        transaction.setUser(fromUser);
        transactionRepository.save(transaction);


        Map<String, Object> response = new HashMap<>();
        response.put("fromAccount", Map.of(
                "accountNumber", fromAccount.getAccountNumber(),
                "balance", fromAccount.getAmount()
        ));
        response.put("toAccount", Map.of(
                "accountNumber", toAccount.getAccountNumber(),
                "balance", toAccount.getAmount()
        ));
        response.put("message", "Transfer successful");

        return ResponseEntity.ok(response);
    }

    private String generateTransactionID() {
        Optional<Transaction> lastTransaction = transactionRepository.findTopByOrderByIdDesc();

        if (lastTransaction.isPresent()) {
            String lastTransNo = lastTransaction.get().getTransactionID();
            if (lastTransNo == null || !lastTransNo.startsWith(AppConstant.TRANSACTION_ID_CODE)) {
                return AppConstant.TRANSACTION_ID;
            }
            int lastNum = Integer.parseInt(lastTransNo.substring(4));
            return AppConstant.TRANSACTION_ID_CODE + (lastNum + 1);
        } else {
            return AppConstant.TRANSACTION_ID;
        }
    }
}
