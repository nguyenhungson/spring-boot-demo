package com.example.springdemo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderRepository {

    @Autowired
    private RedisTemplate<Long, Order> template;

    public void addOrder(long id, Order newOrder) {
        template.opsForValue().set(id, newOrder);
    }

    public Order getOrder(long id) {
        return template.opsForValue().get(id);
    }

    public boolean deleteOrder(long id) {
        return template.delete(id);
    }

}
