package com.example.eatit.owner.service;

import com.example.eatit.owner.entity.*;
import com.example.eatit.owner.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private MenuItemRepository menuRepo;

    // 🔹 1. Get Orders (FIXED)
    public List<Order> getOrders(Long restaurantId) {
        return orderRepo.findByRestaurant_Id(restaurantId);
    }

    // 🔹 2. Accept Order
    public String acceptOrder(Long orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus("PREPARING");
        orderRepo.save(order);

        return "Order Accepted";
    }

    // 🔹 3. Assign Delivery Boy
    public String assignDelivery(Long orderId, Long deliveryId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setDeliveryPersonId(deliveryId);
        order.setStatus("ASSIGNED");
        orderRepo.save(order);

        return "Delivery Assigned";
    }

    // 🔹 4. Add Menu Item
    public MenuItem addMenuItem(MenuItem menuItem) {
        return menuRepo.save(menuItem);
    }
}