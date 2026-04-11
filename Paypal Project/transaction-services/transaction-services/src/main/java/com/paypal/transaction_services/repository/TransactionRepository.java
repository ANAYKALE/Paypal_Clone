package com.paypal.transaction_services.repository;
import com.paypal.transaction_services.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
