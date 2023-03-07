package com.example.demo.service;

import com.example.demo.model.CalcuateData;
import com.example.demo.repository.CalcuateDataRepository;
import com.example.demo.repository.CalculateDataRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class CalucateDataService {
    @Autowired
    private CalcuateDataRepository calcuateDataRepository;
    @Autowired
    private CalculateDataRepository calculateDataRepository;

    public CalcuateData createData(CalcuateData calcuateData){
        calcuateData = calcuateData.setId(null);

        this.calcuateDataRepository.saveAndFlush(calcuateData);
        return calcuateData;
    }

    public List<Map<String,Object>> findAll(){
        return this.calculateDataRepository.findAll();
    }

}
