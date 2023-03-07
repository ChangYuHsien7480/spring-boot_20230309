
package com.example.demo.Helper;

import com.example.demo.model.CalcuateData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.management.InstanceNotFoundException;
import javax.persistence.Convert;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RateHelper {
    public static Object getRate(String str) throws JsonProcessingException {
        List<Map<String, Object>> calcuateData = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("https://tw.rter.info/capi.php");
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String jsonStr = "";
        jsonStr = responseEntity.getBody();
        System.out.println(jsonStr);
        Map<String, Object> resMap = new ObjectMapper().readValue(jsonStr, Map.class);
        Map<String, Map<String,Object>> usdtwd = (Map<String, Map<String,Object>>) resMap.get("USDUSD");
        Map<String, Map<String,Object>> items = (Map<String, Map<String,Object>>) resMap.get("USD" + str);

        Object obj = items.get("Exrate");



        return obj;
    }
}
