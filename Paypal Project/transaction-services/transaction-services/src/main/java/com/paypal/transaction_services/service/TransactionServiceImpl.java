package com.paypal.transaction_services.service;

import com.paypal.transaction_services.entity.Transaction;
import com.paypal.transaction_services.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository repository;
    private final ObjectMapper objectmapper;

    public TransactionServiceImpl(TransactionRepository repository, ObjectMapper objectmapper) {
        this.repository = repository;
        this.objectmapper = objectmapper;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setStatus("SUCCESS");

        return repository.save(transaction);
    }

    @Override
    public List<Transaction> getALLTransaction() {
        return repository.findAll();
    }
}
