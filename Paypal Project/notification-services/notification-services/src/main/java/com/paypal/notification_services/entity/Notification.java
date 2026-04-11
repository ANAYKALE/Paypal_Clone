package com.paypal.notification_services.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String message;

    private LocalDateTime sendAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSendAt() {
        return sendAt;
    }

    public void setSendAt(LocalDateTime sendAt) {
        this.sendAt = sendAt;
    }

    public Notification(Long id, String userId, String message, LocalDateTime sendAt) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.sendAt = sendAt;
    }

    public Notification() {
    }
}
