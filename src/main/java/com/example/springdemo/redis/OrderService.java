package com.example.springdemo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repository;

    public void addOrder(Order newOrder) {
        repository.addOrder(newOrder.getOrderId(), newOrder);
    }

    public Order getOrder(long orderId) {
        return repository.getOrder(orderId);
    }

    public boolean deleteOrder(long orderId) {
        return repository.deleteOrder(orderId);
    }

}
