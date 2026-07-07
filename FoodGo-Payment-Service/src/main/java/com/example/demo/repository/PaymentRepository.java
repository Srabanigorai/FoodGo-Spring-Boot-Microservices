package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find payments by Order ID
    List<Payment> findByOrderId(Long orderId);

    // Find payments by User ID
    List<Payment> findByUserId(Long userId);

    // Find payments by Payment Status
    List<Payment> findByPaymentStatus(String paymentStatus);

}