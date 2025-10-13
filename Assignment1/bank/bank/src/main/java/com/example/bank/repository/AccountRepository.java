package com.example.bank.repository;

import com.example.bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findTopByOrderByIdDesc();

    Account findByUserId(int id);

    Optional<Account> findByAccountNumber(String toAccountNumber);
}
