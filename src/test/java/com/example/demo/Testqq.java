package com.example.demo;

import com.example.demo.Helper.RateHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

public class Testqq {

    @Test
    public void test1() throws JsonProcessingException {
        RateHelper.getRate("TWD");
    }

}
