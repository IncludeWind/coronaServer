package com.example.demo.model;

import java.text.DecimalFormat;

public class locationAndData {

    private int numberOfCases;
    private double longitude;
    private double latitude;

    public locationAndData(int numberOfCases, double longitude, double latitude) {
        this.numberOfCases = numberOfCases;
        this.longitude = longitude;
        this.latitude = latitude;
    }


    public int getNumberOfCases() {
        return numberOfCases;
    }

    public void setNumberOfCases(int numberOfCases) {
        this.numberOfCases = numberOfCases;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
