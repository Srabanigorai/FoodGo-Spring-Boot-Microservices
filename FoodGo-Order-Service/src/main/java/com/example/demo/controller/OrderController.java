package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Add Order
    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    // Get All Orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Get Order By Id
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Update Order
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id,
                             @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    // Delete Order
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }

    // Get Orders By User Id
    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    // Get Orders By Restaurant Id
    @GetMapping("/restaurant/{restaurantId}")
    public List<Order> getOrdersByRestaurantId(@PathVariable Long restaurantId) {
        return orderService.getOrdersByRestaurantId(restaurantId);
    }

    // Get Orders By Status
    @GetMapping("/status/{orderStatus}")
    public List<Order> getOrdersByStatus(@PathVariable String orderStatus) {
        return orderService.getOrdersByStatus(orderStatus);
    }

    // Get Orders By Payment Status
    @GetMapping("/payment/{paymentStatus}")
    public List<Order> getOrdersByPaymentStatus(@PathVariable String paymentStatus) {
        return orderService.getOrdersByPaymentStatus(paymentStatus);
    }

}