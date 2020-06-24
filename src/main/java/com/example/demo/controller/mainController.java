package com.example.demo.controller;


import com.example.demo.model.countryCenter;
import com.example.demo.model.locationAndData;
import com.example.demo.model.table;
import com.example.demo.repository.geoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.coronaDataRepository;
import com.example.demo.model.mainPageList;
import com.example.demo.repository.geoRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class mainController {

    @Autowired
    coronaDataRepository coronaDataRepository;

    @Autowired
    geoRepository geoRepository;




    @GetMapping("/getList")
    public List<mainPageList> getAllCountryWithData(){
        List<String> country = coronaDataRepository.getCountryAllCasePair();
        List<Integer> numbers = coronaDataRepository.getNumberOfCases();

        List<mainPageList> retMap = new ArrayList<>();




        for(int i = 0; i < country.size(); i++){
            retMap.add(new mainPageList(country.get(i),numbers.get(i))) ;
        }
        return retMap;
    }

    @GetMapping("/getGeo")
    public List<locationAndData> getGeo(){
        HashMap<String, table>map = new HashMap<>();
        List<countryCenter> geoRepositoryAll= geoRepository.findAll();

        List<table> coronaNum = coronaDataRepository.findAll();
        for(table t : coronaNum){
            map.put(t.getCountry(),t);
        }

        List<locationAndData> returnValue = new ArrayList<>();

        for(countryCenter cc : geoRepositoryAll){
            if(cc.getCountry().equals(""))
                continue;
            if(map.containsKey(cc.getCountry())){
                table curt = map.get(cc.getCountry());
                returnValue.add(new locationAndData(curt.getTotalCases(),cc.getLongitude(),cc.getLatitude())) ;
            }
        }

        return returnValue;
    }










}
