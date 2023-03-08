package com.example.demo.service;

import com.example.demo.Helper.RateHelper;
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

import javax.persistence.Convert;
import java.util.List;
import java.util.Map;

@Service
public class CalucateDataService {
    @Autowired
    private CalcuateDataRepository calcuateDataRepository;
    @Autowired
    private CalculateDataRepository calculateDataRepository;

    public CalcuateData createData(CalcuateData calcuateData) throws JsonProcessingException {
        calcuateData = calcuateData.setId(null);
        String rate = RateHelper.getRate(calcuateData.getCurrency());

        Double usdRate = 30.0, calRate = Double.valueOf(rate)/usdRate ,resPrice = calcuateData.getPrice();
        if (calcuateData.getCurrency()=="TWD"){
            calcuateData = calcuateData.setResult(resPrice);
        }else{
            calcuateData = calcuateData.setResult(resPrice*calRate);
        }
        calcuateData = calcuateData.setRate(Double.valueOf(rate));

        this.calcuateDataRepository.saveAndFlush(calcuateData);
        return calcuateData;
    }

    public List<Map<String,Object>> findAll(){
        return this.calculateDataRepository.findAll();
    }

}
