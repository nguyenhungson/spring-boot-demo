package com.example.springdemo.redis;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonProperty;

@RedisHash("Order")
public class Order implements Serializable {

    @JsonProperty("order_id")
    private long orderId;

    @JsonProperty("order_code")
    private String code;

    @JsonProperty("order_name")
    private String name;

    public Order(long orderId, String code, String name) {
        this.orderId = orderId;
        this.code = code;
        this.name = name;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
