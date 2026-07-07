package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Notification;
import com.example.demo.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private JavaMailSender mailSender;

    // Send Email and Save Notification
    public Notification sendNotification(Notification notification) {

        try {

            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(notification.getEmail());
            mail.setSubject(notification.getSubject());
            mail.setText(notification.getMessage());

            mailSender.send(mail);

            notification.setStatus("SENT");

        } catch (Exception e) {

            notification.setStatus("FAILED");

        }

        notification.setSentDate(LocalDateTime.now().toString());

        return notificationRepository.save(notification);
    }

    // Get All Notifications
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Get Notification By Id
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    // Search By User
    public List<Notification> getByUser(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    // Search By Order
    public List<Notification> getByOrder(Long orderId) {
        return notificationRepository.findByOrderId(orderId);
    }

    // Search By Email
    public List<Notification> getByEmail(String email) {
        return notificationRepository.findByEmail(email);
    }

}