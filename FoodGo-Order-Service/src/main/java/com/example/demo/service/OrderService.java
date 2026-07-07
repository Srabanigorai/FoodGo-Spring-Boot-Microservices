package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Add Order
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    // Get All Orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get Order By Id
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // Update Order
    public Order updateOrder(Long id, Order order) {

        Order existing = orderRepository.findById(id).orElse(null);

        if (existing != null) {

            existing.setUserId(order.getUserId());
            existing.setRestaurantId(order.getRestaurantId());
            existing.setMenuItemId(order.getMenuItemId());
            existing.setQuantity(order.getQuantity());
            existing.setPrice(order.getPrice());
            existing.setTotalAmount(order.getTotalAmount());
            existing.setOrderStatus(order.getOrderStatus());
            existing.setDeliveryAddress(order.getDeliveryAddress());
            existing.setPaymentStatus(order.getPaymentStatus());
            existing.setOrderTime(order.getOrderTime());

            return orderRepository.save(existing);
        }

        return null;
    }

    // Delete Order
    public String deleteOrder(Long id) {

        orderRepository.deleteById(id);

        return "Order Deleted Successfully";
    }

    // Get Orders By User Id
    public List<Order> getOrdersByUserId(Long userId) {

        return orderRepository.findByUserId(userId);
    }

    // Get Orders By Restaurant Id
    public List<Order> getOrdersByRestaurantId(Long restaurantId) {

        return orderRepository.findByRestaurantId(restaurantId);
    }

    // Get Orders By Status
    public List<Order> getOrdersByStatus(String orderStatus) {

        return orderRepository.findByOrderStatus(orderStatus);
    }

    // Get Orders By Payment Status
    public List<Order> getOrdersByPaymentStatus(String paymentStatus) {

        return orderRepository.findByPaymentStatus(paymentStatus);
    }

}