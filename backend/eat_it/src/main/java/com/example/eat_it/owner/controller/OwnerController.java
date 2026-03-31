package com.example.eatit.owner.controller;

import com.example.eatit.owner.entity.*;
import com.example.eatit.owner.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService service;

    // 🔹 View Orders
    @GetMapping("/orders/{restaurantId}")
    public List<Order> getOrders(@PathVariable Long restaurantId) {
        return service.getOrders(restaurantId);
    }

    // 🔹 Accept Order
    @PutMapping("/accept/{orderId}")
    public String acceptOrder(@PathVariable Long orderId) {
        return service.acceptOrder(orderId);
    }

    // 🔹 Assign Delivery
    @PutMapping("/assign")
    public String assignDelivery(@RequestParam Long orderId,
                                 @RequestParam Long deliveryId) {
        return service.assignDelivery(orderId, deliveryId);
    }

    // 🔹 Add Food Item
    @PostMapping("/menu")
    public MenuItem addMenu(@RequestBody MenuItem menuItem) {
        return service.addMenuItem(menuItem);
    }
}