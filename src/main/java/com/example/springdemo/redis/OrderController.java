package com.example.springdemo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.base.Base;
import com.example.springdemo.base.BaseController;

@RestController
public class OrderController extends BaseController {

    @Autowired
    private OrderService service;

    @PostMapping("/api/order")
    Base newOrder(@RequestBody Order newOrder) {
        service.addOrder(newOrder);
        return ApiResponse(HttpStatus.OK.value(), "OK");
    }

    @GetMapping("/api/order/{id}")
    Base getOrder(@PathVariable long id) {
        Order order = service.getOrder(id);
        return ApiResponse(HttpStatus.OK.value(), "OK", order);
    }

    @DeleteMapping("/api/order/{id}")
    Base deleteOrder(@PathVariable long id) {
        boolean isDelete = service.deleteOrder(id);
        return ApiResponse(HttpStatus.OK.value(), "OK", isDelete);
    }

}
