package com.example.springdemo.base;

public class BaseController {

    public Base ApiResponse(int code, String message) {
        return new Base(code, message, null);
    }
    
    public Base ApiResponse(int code, String message, Object data) {
        return new Base(code, message, data);
    }

}
