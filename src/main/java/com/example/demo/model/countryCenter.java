package com.example.demo.model;


import javax.persistence.*;
import java.text.DecimalFormat;

@Entity
@Table(name = "center_of_country")
public class countryCenter {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "iso_a3")
    private String iso_a3;
    @Column(name = "country")
    private String country;
    @Column(name = "Longitude")
    private double Longitude;
    @Column(name = "Latitude")
    private double Latitude;

    public countryCenter(String iso_a3, String country, double longitude, double latitude) {
        this.iso_a3 = iso_a3;
        this.country = country;
        Longitude = longitude;
        Latitude = latitude;
    }
    public countryCenter() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getIso_a3() {
        return iso_a3;
    }

    public void setIso_a3(String iso_a3) {
        this.iso_a3 = iso_a3;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }
}
