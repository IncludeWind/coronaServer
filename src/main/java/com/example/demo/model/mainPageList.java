package com.example.demo.model;

public class mainPageList {

    private String country;
    private int totalCases;

    public mainPageList(String country, int totalCases) {
        this.country = country;
        this.totalCases = totalCases;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }
}
