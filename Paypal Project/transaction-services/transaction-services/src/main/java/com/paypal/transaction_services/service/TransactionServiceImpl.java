package com.paypal.transaction_services.service;

import com.paypal.transaction_services.kafka.KafkaEventProducer;
import com.paypal.transaction_services.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;
import com.paypal.transaction_services.entity.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository repository;
    private final ObjectMapper objectMapper;
    private final KafkaEventProducer kafkaEventProducer;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public TransactionServiceImpl(TransactionRepository repository,
                                  KafkaEventProducer kafkaEventProducer,
                                  ObjectMapper objectMapper, ObjectMapper objectmapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
        this.kafkaEventProducer = kafkaEventProducer;
        this.objectmapper = objectmapper;
    }
    private final ObjectMapper objectmapper;

    public TransactionServiceImpl(TransactionRepository repository, ObjectMapper objectMapper, KafkaEventProducer kafkaEventProducer, ObjectMapper objectmapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
        this.kafkaEventProducer = kafkaEventProducer;
        this.objectmapper = objectmapper;
    }

    @Override
    public Transaction createTransaction(Transaction request) {
        System.out.println("🚀 Entered createTransaction()");

        Long senderId = request.getSenderId();
        Long receiverId = request.getReceiverId();
        Double amount = request.getAmount();




        Transaction transaction = new Transaction();
        transaction.setSenderId(senderId);
        transaction.setReceiverId(receiverId);
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setStatus("SUCCESS");

        System.out.println("📥 Incoming Transaction object: " + transaction);

        Transaction saved = repository.save(transaction);
        System.out.println("💾 Saved Transaction from DB: " + saved);

        try {
//            String eventPayload = objectMapper.writeValueAsString(saved);
//            String key = String.valueOf(saved.getId());
//            kafkaEventProducer.sendTransactionEvent(key, eventPayload);

            String key = String.valueOf(saved.getId());
            kafkaEventProducer.sendTransactionEvent(key, saved); // send actual object!

            System.out.println("🚀 Kafka message sent");
        } catch (Exception e) {
            System.err.println("❌ Failed to send Kafka event: " + e.getMessage());
            e.printStackTrace();
        }

        return saved;
    }

}
