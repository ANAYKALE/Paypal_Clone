package com.paypal.transaction_services.service;

import com.paypal.transaction_services.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TransactionService {
Transaction createTransaction(Transaction transaction);

List<Transaction> getALLTransaction();
}
