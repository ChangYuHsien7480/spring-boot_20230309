package com.example.demo.controller;

import com.example.demo.model.CalcuateData;
import com.example.demo.service.CalucateDataService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.catalina.User;
import org.apache.tomcat.util.json.JSONParserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.Console;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/calculate")
public class TestController2 {

    @Autowired
    private CalucateDataService calucateDataService;

    @PostMapping("/createData")
    public CalcuateData createData(@RequestBody CalcuateData calcuateData) throws JsonProcessingException {
        return this.calucateDataService.createData(calcuateData);
    }
    @GetMapping("/findAll")
    public List<Map<String,Object>> findAll(){
        return this.calucateDataService.findAll();
    }

//    @GetMapping("/test")
//    public Map<String, Object> test () throws JsonProcessingException {
//        return this.calucateDataService;
//    }
}
