package com.example.demo.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = {Exception.class})
    public Object handleException(Exception e, HttpServletResponse response, HttpServletRequest request) {
        e.printStackTrace();
        System.out.println("get exception");
        return "ERROR";
    }
}
