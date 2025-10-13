package com.example.bank.repository;

import com.example.bank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    Optional<Transaction> findTopByOrderByIdDesc();

    List<Transaction> findAllByUserId(int id);
}
