package com.paypal.notification_services.repository;
import com.paypal.notification_services.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public  interface NotificationRepository extends JpaRepository<Notification,Long> {

   List<Notification> findByUserId(String userId);


}
