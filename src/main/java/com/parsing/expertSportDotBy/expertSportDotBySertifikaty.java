package com.parsing.expertSportDotBy;

import com.parsing.csv.WriterForOut;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class expertSportDotBySertifikaty {

    public expertSportDotBySertifikaty() throws IOException, InterruptedException {

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date nowTime = new Date();


        String namePortal = "expert-sport.by";
        String nameProductGroup = "Подарочные сертификаты";


        String linkProtein = "https://expert-sport.by/katalog/podarochnye-sertifikaty/?limit=100";
        Document doc1 = null;
        while (true) {
            try {
                doc1 = Jsoup.connect(linkProtein).get();
                break;
            }catch (Exception e){
                System.out.println("Обрыв коннекта, подключаемся! Возможная причина - отсутствие интернета или сайт не работает!");
                Thread.sleep(3000);
            }
        }
        Thread.sleep(1000);
        Elements countPage = doc1.getElementsByAttributeValue("class", "pagination");

        //System.out.println(String.valueOf(countPage.get(0)).split("page=")[String.valueOf(countPage.get(0)).split("page=").length-1].split("\">")[0]);

        int maxCountPage = 1;
        try {
            maxCountPage = Integer.parseInt(String.valueOf(countPage.get(0)).split("page=")[String.valueOf(countPage.get(0)).split("page=").length-1].split("\">")[0]); //максимальное количество страниц
            //    System.out.println(maxCountPage);
        } catch (Exception e){

        }

        String link =  "";

        for (int v = 1; v <= maxCountPage; v++) {
            if (v == 1){
                link = linkProtein;
            } else {
                link = "https://expert-sport.by/katalog/podarochnye-sertifikaty/?limit=100&page=" + v;
            }

            Document doc = null;
            while (true) {
                try {
                    doc = Jsoup.connect(link).get();
                    break;
                }catch (Exception e){
                    System.out.println("Обрыв коннекта, подключаемся! Возможная причина - отсутствие интернета или сайт не работает!");
                    Thread.sleep(3000);
                }
            }
            Thread.sleep(1000);
            Elements product = doc.getElementsByAttributeValue("class", "spacer");

            for (int i = 0; i < product.size(); i++) {

                String brand = "";
                try {
                    brand = String.valueOf(product.get(i).getElementsByAttributeValue("class", "item-mf-logo")).split("alt=\"")[1].split("\">")[0].replaceAll(",", ".");
                } catch (Exception e){

                }

                String description = "";
                try {
                    description = String.valueOf(product.get(i).getElementsByAttributeValue("class", "item-title")).split("\">")[2].split("</a>")[0].replaceAll(",|\n", ".");
                } catch (Exception e){

                }

                String weight = "Вес в описании";

                String stock = "";
                try {
                    stock = String.valueOf(product.get(i).getElementsByAttributeValue("class", "item-in-stock")).split("\">")[1].split("</p>")[0].replaceAll(",", ".");
                } catch (Exception e){
                    stock = "нет в наличии";
                }

                String price = "";
                try {
                    price = String.valueOf(product.get(i).getElementsByAttributeValue("class", "PricesalesPrice")).split("\">")[1].split(" руб.")[0].replaceAll("\n|\"| ", "");
                } catch (Exception e){

                }

                String priceAction = "";
                try {
                    String skidka = String.valueOf(product.get(i).getElementsByAttributeValue("class", "item_badge item-skidka")).split("<b>")[1].split("</b>")[0];
                    //System.out.println("skidka" + skidka);
                    double priceOld = Double.parseDouble(price) / (1 - (Double.parseDouble(skidka)/100));
                    priceOld= Math.round(priceOld*100)/100;
                    //System.out.println("расч " + priceOld);
                    priceAction = price;

                    //String temporery = String.valueOf(priceOld);
                    price = String.valueOf(priceOld);

                } catch (Exception e){

                }

                String image = "";
                try {
                    image = String.valueOf(product.get(i).getElementsByAttributeValue("class", "vm-product-media-container")).split("src=\"")[1].split("\"")[0].replaceAll(",", ".");
                } catch (Exception e){

                }

                String linkProd = "";
                try {
                    linkProd = String.valueOf(product.get(i).getElementsByAttributeValue("class", "item-title")).split("href=\"")[1].split("\"")[0].replaceAll(",", ".");
                } catch (Exception e){

                }


/*                System.out.println(brand);
                System.out.println(description);
                System.out.println(weight);
                System.out.println(stock);
                System.out.println(price);
                System.out.println(priceAction);
                System.out.println(image);
                System.out.println(linkProd);*/


                ArrayList<String> productList = new ArrayList<>();

                productList.add(namePortal);
                productList.add(nameProductGroup);
                productList.add(brand);
                productList.add(description);
                productList.add("Вес в описании");
                productList.add(stock);
                productList.add(price);
                productList.add(priceAction);
                productList.add(image);
                productList.add(linkProd);
                productList.add(sdfDate.format(nowTime));

                new WriterForOut().writeToFile(productList, "D:\\fizcult.csv");



            }


        }

    }


}
