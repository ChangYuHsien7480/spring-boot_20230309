package com.example.demo.model;


import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Table(name = "calculate_record")
@Entity(name = "calculate_record")
public class CalcuateData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String currency;
    private double rate;
    private double price;
    private double discount;
    private double result;

    public Integer getId() {
        return id;
    }

    public CalcuateData setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCurrency(){
        return this.currency;
    }

    public CalcuateData setCurrency(String currency){
        this.currency = currency;
        return this;
    }

    public double getRate() {
        return rate;
    }

    public CalcuateData setRate(double rate) {
        this.rate = rate;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public CalcuateData setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getDiscount() {
        return discount;
    }

    public CalcuateData setDiscount(double discount) {
        this.discount = discount;
        return this;
    }

    public double getResult() {
        return result;
    }

    public CalcuateData setResult(double result) {
        this.result = result;
        return this;
    }

    /*
    public String getTime() {
        return time;
    }

    public CalcuateData setTime(String time) {
        this.time = time;
        return this;
    }
     */
}
