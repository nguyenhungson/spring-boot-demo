package com.example.springdemo.base;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Base {
    
    @JsonProperty("code")
    private int code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private Object data;


    public Base(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }    

}
