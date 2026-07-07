package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Notification;
import com.example.demo.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Send Notification
    @PostMapping
    public Notification sendNotification(@RequestBody Notification notification) {
        return notificationService.sendNotification(notification);
    }

    // Get All Notifications
    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    // Get By Id
    @GetMapping("/{id}")
    public Notification getNotification(@PathVariable Long id) {
        return notificationService.getNotificationById(id);
    }

    // Get By User
    @GetMapping("/user/{userId}")
    public List<Notification> getByUser(@PathVariable Long userId) {
        return notificationService.getByUser(userId);
    }

    // Get By Order
    @GetMapping("/order/{orderId}")
    public List<Notification> getByOrder(@PathVariable Long orderId) {
        return notificationService.getByOrder(orderId);
    }

    // Get By Email
    @GetMapping("/email/{email}")
    public List<Notification> getByEmail(@PathVariable String email) {
        return notificationService.getByEmail(email);
    }

}