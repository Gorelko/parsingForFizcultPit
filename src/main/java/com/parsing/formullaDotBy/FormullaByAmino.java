package com.parsing.formullaDotBy;

import com.parsing.csv.WriterForOut;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FormullaByAmino {

    public FormullaByAmino() throws IOException, InterruptedException {

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date nowTime = new Date();


        String namePortal = "formulla.by";
        String nameProductGroup = "Аминокислоты";


        Document doc1 = null;
        while (true) {
            try {

                String link = "https://formulla.by/nutrition/amino-acids/?limit=120";
                doc1 = Jsoup.connect(link).get();
                Thread.sleep(1000);
                break;
            }catch (Exception e){
                System.out.println("Обрыв коннекта, подключаемся! Возможная причина - отсутствие интернета или сайт не работает!");
                Thread.sleep(3000);
            }
        }



        int countPage = 1;

        try {
            countPage = Integer.parseInt(String.valueOf(doc1.getElementsByAttributeValue("class","pagpages clearfix")).split("всего ")[1].split(" страниц")[0]);
        }catch (Exception e){

        }



        for (int x = 1; x <= countPage; x++) {

            Thread.sleep(1000);
            Document doc = null;
            while (true) {
                try {
                    doc = Jsoup.connect("https://formulla.by/nutrition/amino-acids/?limit=120&page="+ x).get();
                    Thread.sleep(1000);
                    break;
                }catch (Exception e){
                    System.out.println("Обрыв коннекта, подключаемся! Возможная причина - отсутствие интернета или сайт не работает!");
                    Thread.sleep(3000);
                }
            }
            Thread.sleep(1000);
            Elements product = doc.getElementsByAttributeValueStarting("class","product-thumb"); //.getElementsByAttributeValue("class","product-layout product-grid");


            for (int i = 0; i < product.size(); i++) {


                String nameBrand = "";
                try {
                    String randomText = String.valueOf(product.get(i).getElementsByAttributeValue("class","dotted-line_title").get(0)).split("\">")[1].split("</span")[0].replaceAll("\n","");
                    if (randomText.equals("Производитель:")){
                        nameBrand = String.valueOf(product.get(i).getElementsByAttributeValue("class","dotted-line_right").get(0)).split("\">")[1].split("</span")[0].replaceAll("\n","");
                    }
                }catch (Exception e) {

                }

                String discription = "";
                try {
                    discription = String.valueOf(product.get(i).getElementsByAttributeValue("itemprop","name").get(0)).split("name\">")[1].split("</span")[0].replaceAll("\n","");
                }catch (Exception e) {

                }

                String weight = "";
                try {
                    Elements weightElements = product.get(i).getElementsByAttributeValue("class","dotted-line_title");
                    Elements weightElements2 = product.get(i).getElementsByAttributeValue("class","dotted-line_right");


                    for (int j = 0; j < weightElements.size(); j++) {
                        if (String.valueOf(weightElements.get(j)).split("dotted-line_title\">")[1].split("</span")[0].equals("Упаковка:")){
                            weight = String.valueOf(weightElements2.get(j)).split("dotted-line_right\">")[1].split("</span")[0];
                        }
                    }
                }catch (Exception e) {

                }

                String stock = "В наличии";
                try {
                    stock = String.valueOf(product.get(i).getElementsByAttributeValue("class","stiker_panel").get(0)).split("stiker_netu\">")[1].split("</span")[0];

                }catch (Exception e) {

                }

                String price = "";
                String priceDiscount = "";
                try {
                    price = String.valueOf(product.get(i).getElementsByAttributeValue("itemprop","price")).split("content=\"")[1].split("\">")[0];

                }catch (Exception e){
                    try {
                        price = String.valueOf(product.get(i).getElementsByAttributeValue("class","old-price")).split("old-price\">")[1].split(" руб.")[0];
                        priceDiscount = String.valueOf(product.get(i).getElementsByAttributeValue("class","special-price")).split("special-price\">")[1].split(" руб.")[0];
                    }catch (Exception n){

                    }
                }


                String image = "";
                try {
                    image = String.valueOf(product.get(i).getElementsByAttributeValue("class","img-responsive ").get(0)).split("src=\"")[1].split("\" ")[0];
                }catch (Exception e) {

                }
                String link = "";
                try {
                    link = String.valueOf(product.get(i).getElementsByAttributeValue("class","image").get(0)).split("href=\"")[1].split("\">")[0];
                }catch (Exception e) {

                }

                List<String> productList = new ArrayList<>();

                productList.add(namePortal);
                productList.add(nameProductGroup.replaceAll(",", "."));
                productList.add(nameBrand.replaceAll(",", "."));
                productList.add(discription.replaceAll(",", "."));
                productList.add(weight.replaceAll(",", "."));
                productList.add(stock);
                productList.add(price.replaceAll(",", "."));
                productList.add(priceDiscount);
                productList.add(image.replaceAll(",", "."));
                productList.add(link.replaceAll(",", "."));
                productList.add(sdfDate.format(nowTime));

                new WriterForOut().writeToFile(productList, "D:\\fizcult.csv");




            }




        }

    }

}
