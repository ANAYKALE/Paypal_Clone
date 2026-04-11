package com.paypal.notification_services.Kafka;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.paypal.notification_services.entity.Notification;
import com.paypal.notification_services.entity.Transaction;
import com.paypal.notification_services.repository.NotificationRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NotificationConsumer {

    private final NotificationRepository notificationRepository;
    private final ObjectMapper Mapper;

    public NotificationConsumer(NotificationRepository notificationRepository){

        this.notificationRepository=notificationRepository;

        this.Mapper=new ObjectMapper();
        this.Mapper.registerModule(new JavaTimeModule());
        this.Mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @KafkaListener(topics ="txn-initiated",groupId="notification-group")
    public void listener(String message) throws JsonProcessingException {
        Transaction txn= Mapper.readValue(message,Transaction.class);
        Notification notification=new Notification();
        String recieverUserId= String.valueOf(txn.getReceiverId());
        String senderUserId= String.valueOf(txn.getSenderId());
        String notify ="$ "+txn.getAmount()+ "receive from" + txn.getSenderId();
        notification.setMessage(notify);
        LocalDateTime now= LocalDateTime.now();
        notification.setSendAt(now);
        notificationRepository.save(notification);
    }

}
