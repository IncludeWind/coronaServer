package com.example.demo.model;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;


@Entity
@DynamicUpdate
@Table(name="coronaCaseReport")
public class table {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "Country")
    private String country;





    @Column(name = "Total_Cases")
    private int totalCases;

    @Column(name = "New_Cases")
    private String newCases;

    @Column(name = "Total_Deaths")
    private String totalDeaths;

    @Column(name = "New_deaths")
    private String newDeaths;

    @Column(name = "Total_recovered")
    private String totalRecovered;

    @Column(name = "Active_Cases")
    private String activeCases;

    @Column(name = "Serious")
    private String seriousCases;

    @Column(name = "Tot_Cases_Per_M")
    private String totalCasesPerM;

    @Column(name = "Deaths_Per_M")
    private String totalDeathsPerM;

    @Column(name = "Total_Tests")
    private String totalTests;

    @Column(name = "Tests_Per_M")
    private String totalTestsPerM;








    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNewCases() {
        return newCases;
    }

    public void setNewCases(String newCases) {
        this.newCases = newCases;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

    public String getSeriousCases() {
        return seriousCases;
    }

    public void setSeriousCases(String seriousCases) {
        this.seriousCases = seriousCases;
    }

    public String getTotalCasesPerM() {
        return totalCasesPerM;
    }

    public void setTotalCasesPerM(String totalCasesPerM) {
        this.totalCasesPerM = totalCasesPerM;
    }

    public String getTotalDeathsPerM() {
        return totalDeathsPerM;
    }

    public void setTotalDeathsPerM(String totalDeathsPerM) {
        this.totalDeathsPerM = totalDeathsPerM;
    }

    public String getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(String totalTests) {
        this.totalTests = totalTests;
    }

    public String getTotalTestsPerM() {
        return totalTestsPerM;
    }

    public void setTotalTestsPerM(String totalTestsPerM) {
        this.totalTestsPerM = totalTestsPerM;
    }


}
