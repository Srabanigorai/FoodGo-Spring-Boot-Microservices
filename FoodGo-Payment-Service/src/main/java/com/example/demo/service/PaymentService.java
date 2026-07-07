package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Add Payment
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Get All Payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get Payment By Id
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    // Update Payment
    public Payment updatePayment(Long id, Payment payment) {

        Payment existing = paymentRepository.findById(id).orElse(null);

        if (existing != null) {

            existing.setOrderId(payment.getOrderId());
            existing.setUserId(payment.getUserId());
            existing.setAmount(payment.getAmount());
            existing.setPaymentMethod(payment.getPaymentMethod());
            existing.setPaymentStatus(payment.getPaymentStatus());
            existing.setTransactionId(payment.getTransactionId());
            existing.setPaymentDate(payment.getPaymentDate());

            return paymentRepository.save(existing);
        }

        return null;
    }

    // Delete Payment
    public String deletePayment(Long id) {

        paymentRepository.deleteById(id);

        return "Payment Deleted Successfully";
    }

    // Find By Order Id
    public List<Payment> getPaymentsByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    // Find By User Id
    public List<Payment> getPaymentsByUserId(Long userId) {
        return paymentRepository.findByUserId(userId);
    }

    // Find By Payment Status
    public List<Payment> getPaymentsByStatus(String paymentStatus) {
        return paymentRepository.findByPaymentStatus(paymentStatus);
    }

}