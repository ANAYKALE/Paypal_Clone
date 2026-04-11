package com.paypal.notification_services.service;

import com.paypal.notification_services.entity.Notification;
import com.paypal.notification_services.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private NotificationRepository notificationRepository;
    @Override
    public Notification sendNotification(Notification notification) {
        notification.setSendAt(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotificationByUserId(String userId) {
        return notificationRepository.findByUserId(userId);
    }
}
