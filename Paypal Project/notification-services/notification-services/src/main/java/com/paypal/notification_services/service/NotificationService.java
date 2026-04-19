package com.paypal.notification_services.service;

import com.paypal.notification_services.entity.Notification;


import java.util.List;

public interface NotificationService {

    Notification sendNotification(Notification notification);

    List<Notification> getNotificationByUserId(String userId);
}
