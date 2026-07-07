package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Payment;
import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Add Payment
    @PostMapping
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentService.addPayment(payment);
    }

    // Get All Payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Get Payment By Id
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    // Update Payment
    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id,
                                 @RequestBody Payment payment) {
        return paymentService.updatePayment(id, payment);
    }

    // Delete Payment
    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable Long id) {
        return paymentService.deletePayment(id);
    }

    // Get Payments By Order Id
    @GetMapping("/order/{orderId}")
    public List<Payment> getPaymentsByOrderId(@PathVariable Long orderId) {
        return paymentService.getPaymentsByOrderId(orderId);
    }

    // Get Payments By User Id
    @GetMapping("/user/{userId}")
    public List<Payment> getPaymentsByUserId(@PathVariable Long userId) {
        return paymentService.getPaymentsByUserId(userId);
    }

    // Get Payments By Status
    @GetMapping("/status/{status}")
    public List<Payment> getPaymentsByStatus(@PathVariable String status) {
        return paymentService.getPaymentsByStatus(status);
    }
}