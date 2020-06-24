package com.example.demo;

import com.example.demo.model.countryCenter;
import com.example.demo.model.table;
import com.example.demo.repository.coronaDataRepository;
import com.example.demo.repository.geoRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


@Component
public class initDatabase  {

    private static final String baseUrl = "https://www.worldometers.info/coronavirus/";

    @Autowired
    private coronaDataRepository coronaDataRepository;
//
//    @Autowired
//    private wikiDataRepository wikiDataRepository;

//    @Autowired
//    private bbcCoronaRepository bbcCoroanRepository;

    @Autowired
    private geoRepository geoRepository;





    @PostConstruct
    public void initDatabase (){

//        try{
//            Document doc = Jsoup.connect(baseUrl).get();
//
//            Element table = doc.getElementById("main_table_countries_today");
//
//            Elements rows = table.getElementsByTag("tr");



            try{
                Connection con= DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/coronaData?useLegacyDatetimeCode=false&serverTimezone=UTC","root","Include_7");

                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from countryCenter");
                while(rs.next()){
                    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getBigDecimal(3)+ "  "+rs.getBigDecimal(4));
                    geoRepository.save(new countryCenter(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getDouble(4)));
                }

                con.close();

            }catch (SQLException e){
                e.printStackTrace();
            }


            System.out.println("this is corona data");
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("running: "+ new java.util.Date());
                    try {
                        Document doc = Jsoup.connect(baseUrl).get();
                        Element table = doc.getElementById("main_table_countries_today");
                        Elements rows = table.getElementsByTag("tr");
                        for(Element row : rows){
                            Elements cells = row.getElementsByTag("td");

                            com.example.demo.model.table t = new table();

                            if(cells.size()!=19){
                                continue;
                            }

                            if(cells.get(1).text().equals("Total:")||cells.get(1).text().equals(""))
                                continue;
                            t.setCountry(cells.get(1).text());


                            if(cells.get(2).text().equals("N/A")){
                                t.setTotalCases(-1);
                            }else{

                                t.setTotalCases(Integer.parseInt(cells.get(2).text().replaceAll(",","")));
                            }

                            t.setNewCases(cells.get(3).text());
                            t.setTotalDeaths(cells.get(4).text());
                            t.setNewDeaths(cells.get(5).text());
                            t.setTotalRecovered(cells.get(6).text());
                            t.setActiveCases(cells.get(7).text());
                            t.setSeriousCases(cells.get(8).text());
                            t.setTotalCasesPerM(cells.get(9).text());
                            t.setTotalDeathsPerM(cells.get(10).text());
                            t.setTotalTests(cells.get(11).text());
                            t.setTotalTestsPerM(cells.get(12).text());

                            coronaDataRepository.save(t);
                        }
                    }catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            },0,1000000);


//            for(Element row : rows){
//                        Elements cells = row.getElementsByTag("td");
//                        //int size = cells.size();
//
//
//
//
//                        com.example.demo.model.table t = new table();
//
//                        if(cells.size()!=19){
//                            continue;
//                        }
//
//
//
//
//                if(cells.get(1).text().equals("Total:")||cells.get(1).text().equals(""))
//                    continue;
//                        t.setCountry(cells.get(1).text());
//
//
//                        if(cells.get(2).text().equals("N/A")){
//                            t.setTotalCases(-1);
//                        }else{
//
//                            t.setTotalCases(Integer.parseInt(cells.get(2).text().replaceAll(",","")));
//                        }
//
//
//                        t.setNewCases(cells.get(3).text());
//                        t.setTotalDeaths(cells.get(4).text());
//                        t.setNewDeaths(cells.get(5).text());
//                        t.setTotalRecovered(cells.get(6).text());
//                        t.setActiveCases(cells.get(7).text());
//                        t.setSeriousCases(cells.get(8).text());
//                        t.setTotalCasesPerM(cells.get(9).text());
//                        t.setTotalDeathsPerM(cells.get(10).text());
//                        t.setTotalTests(cells.get(11).text());
//                        t.setTotalTestsPerM(cells.get(12).text());
//
//
//                        coronaDataRepository.save(t);
//                    }

            System.out.println("finish");

//            for(Element table : tables){
//
//                Elements rows = table.select("role='row'");
//
//                for(Element row : rows){
//                    System.out.println(row.text());
//                }
//            }
//        }catch (IOException ex){
//            ex.printStackTrace();
//        }




    }
}
