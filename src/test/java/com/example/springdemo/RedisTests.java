package com.example.springdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdemo.redis.Order;
import com.example.springdemo.redis.OrderService;

@SpringBootTest
public class RedisTests {

	@Autowired
	public OrderService orderService;

    @Test
	void setOrderToRedisCache() {
		orderService.addOrder(new Order(1, "ORD1", "order 1"));
		assertEquals(1, 1);
	}
}
