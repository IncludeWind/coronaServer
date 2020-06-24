package com.example.demo.repository;

import com.example.demo.model.table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

@Repository
public interface coronaDataRepository extends JpaRepository<table, Integer> {

    @Query("select country from table  order by totalCases desc")
    List<String> getCountryAllCasePair();
    @Query("select totalCases from table order by totalCases desc")
    List<Integer> getNumberOfCases();
//    @Query("select country, totalCases from table where id > 8 and id < 224 order by totalCases")
//    TreeMap<String, Integer> getpair();

//
//    @Query("SELECT table.totalCases from table ")
//    List<Integer> getData();
//    @Query("SELECT  countryCenter.longitude from countryCenter ")
//    List<DecimalFormat>getLongitude();
//    @Query("SELECT  countryCenter.latitude from countryCenter ")
//    List<DecimalFormat>getLatitude();


}
