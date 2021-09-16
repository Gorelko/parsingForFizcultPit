package com.parsing.sportNutritionDotBy;

import com.parsing.csv.WriterForOut;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class sportNutritionProtein {

    public sportNutritionProtein() throws IOException, InterruptedException {

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date nowTime = new Date();


        String namePortal = "sport-nutrition.by";
        String nameProductGroup = "Протеины";


        String link1 = "https://sport-nutrition.by/proteiny";
        List<String> listLink = new ArrayList();
        listLink.add(link1);

        Document doc1 = null;
        while (true) {
            try {

                doc1 = Jsoup.connect(link1).get();
                Thread.sleep(1000);
                break;
            }catch (Exception e){
                System.out.println("Обрыв коннекта, подключаемся! Возможная причина - отсутствие интернета или сайт не работает!");
                Thread.sleep(3000);
            }
        }

        Elements product = doc1.getElementsByAttributeValue("class","product-line");

        for (int i = 0; i < product.size(); i++) {

            String brandName = "";
            try {
                String linkBrandName = "https://sport-nutrition.by"+String.valueOf(product.get(i).getElementsByAttributeValue("class", "name")).split("href=\"")[1].split("\">")[0];
               // System.out.println(String.valueOf(product.get(i).getElementsByAttributeValue("class", "name")).split("href=\"")[1].split("\">")[0]);
                Document doc2 = Jsoup.connect(linkBrandName).get();
                Thread.sleep(500);
                brandName = String.valueOf(doc2.getElementsByAttributeValue("class", "product-logo")).split("alt=\"")[1].split("\" ")[0];

            }catch (Exception e){
                //System.out.println("ошибка");
            }

            String discription ="";
            try {
                discription = String.valueOf(product.get(i).getElementsByAttributeValue("class", "name")).split("\">")[2].split("</a>")[0];
            }catch (Exception e){

            }

            String image = "";
            try {
                image = "https://sport-nutrition.by"+String.valueOf(product.get(i).getElementsByAttributeValue("class", "img")).split("src=\"")[1].split("\"")[0];
            }catch (Exception e){

            }
            String linkProduct = "";
            try {
                linkProduct = "https://sport-nutrition.by"+String.valueOf(product.get(i).getElementsByAttributeValue("class", "name")).split("href=\"")[1].split("\">")[0];
            }catch (Exception e){

            }

            String weight = "";
            String priceTotal = "";
            String priceDiscount = "";

            Elements productPriceAndWeight = null;
            try {
                productPriceAndWeight = product.get(i).getElementsByAttributeValue("class", "variant_data");

                for (int j = 0; j < productPriceAndWeight.size(); j++) {

                    weight = String.valueOf(productPriceAndWeight.get(j)).split("\"weight\">")[1].split("</span>")[0];
                    priceTotal = String.valueOf(productPriceAndWeight.get(j)).split("total\">")[1].split("</span>")[0];
                    try {
                        priceDiscount = String.valueOf(productPriceAndWeight.get(j)).split("discount\">")[1].split("</span>")[0];
                    }catch (Exception e){
                        priceDiscount = "";
                    }
                    if (!priceDiscount.equals("")){
                        String timepory = priceTotal;
                        priceTotal = priceDiscount;
                        priceDiscount = timepory;
                    }


                    List<String> productList = new ArrayList<>();

                    productList.add(namePortal);
                    productList.add(nameProductGroup.replaceAll(";", ".").replaceAll(",", "."));
                    productList.add(brandName.replaceAll(";", ".").replaceAll(",", "."));
                    productList.add(discription.replaceAll(";", ".").replaceAll(",", "."));
                    productList.add(weight.replaceAll(";", ".").replaceAll(",", "."));
                    productList.add("В наличии");
                    productList.add(priceTotal.replaceAll(",", ".").replaceAll(" р.", ""));
                    productList.add(priceDiscount.replaceAll(",", ".").replaceAll(" р.", ""));
                    productList.add(image.replaceAll(";", ".").replaceAll(",", "."));
                    productList.add(linkProduct.replaceAll(";", ".").replaceAll(",", "."));
                    productList.add(sdfDate.format(nowTime));



                    // System.out.println(productList);
                    new WriterForOut().writeToFile(productList, "D:\\fizcult.csv");


                }

            }catch (Exception e){

            }


        }




    }

}
