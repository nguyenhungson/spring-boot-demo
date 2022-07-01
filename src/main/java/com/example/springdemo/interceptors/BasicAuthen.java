package com.example.springdemo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class BasicAuthen implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String appId = request.getHeader("x_app_id");
        if (appId == null || !appId.equals("123")) {
            response.sendError(HttpStatus.SC_FORBIDDEN, "Forbidden");
            return false;
        }
        
        return true;
    }
    
    

}
