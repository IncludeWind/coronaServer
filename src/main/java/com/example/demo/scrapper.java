package com.example.demo;


import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import java.sql.*;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;


public class scrapper {

    private static final String baseUrl = "https://www.worldometers.info/coronavirus/";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/coronaData?useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String userName = "root";
    private static final String passWord = "Include_7";


    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,userName,passWord);


//        WebClient client = new WebClient();

//        client.getOptions().setJavaScriptEnabled(true);
//        client.getOptions().setCssEnabled(false);
//        client.getOptions().setUseInsecureSSL(true);
//        try{
//            HtmlPage page = client.getPage(baseUrl);
//            final HtmlTable table = (HtmlTable) page.getElementById("main_table_countries_today");
//            final HtmlTableHeader header = table.getHeader();
//            final List<HtmlTableBody> bodys = table.getBodies();

            //print the header
//            System.out.println("this is the header part of the table");
//            final List<HtmlTableRow> headerRows = header.getRows();
//            if(headerRows.isEmpty()){
//                System.out.println("header of this table is empty");
//            }
//            for(HtmlTableRow row: headerRows){
//                System.out.println(row.asText());
//            }
//            //print the body
//            System.out.println("this is the body part if the table");
//            int bodyindex = 1;
//            for(HtmlTableBody body: bodys){
//                System.out.println("this is body: "+ bodyindex);
//                final List<HtmlTableRow> bodyRows = body.getRows();
//
//                for(HtmlTableRow row: bodyRows){
//                    final List<HtmlTableCell> celllist= row.getCells();
//                    for( HtmlTableCell cell : celllist){
//
//                       System.out.print(cell.asText()+" ");
//                    }
//                    System.out.print(celllist.size());
//                    System.out.println();
//                }
//                bodyindex++;
//
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }



    }
}
