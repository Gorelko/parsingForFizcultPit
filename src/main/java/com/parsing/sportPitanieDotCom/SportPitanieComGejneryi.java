package com.parsing.sportPitanieDotCom;

import com.parsing.csv.WriterForOut;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SportPitanieComGejneryi {

    public SportPitanieComGejneryi() throws IOException, InterruptedException {

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date nowTime = new Date();


        String namePortal = "sport-pitanie.com";
        String nameProductGroup = "Гейнеры";


        String linkProtein = "https://sport-pitanie.com/gejneryi/?page=1&limit=48";
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
        Elements countPage = doc1.getElementsByAttributeValue("class", "page-link");

        //System.out.println(countPage);

        int maxCountPage = 1;
        try {
            maxCountPage = Integer.parseInt(String.valueOf(countPage).split("page=")[String.valueOf(countPage).split("page=").length-1].split("&")[0]); //максимальное количество страниц
            //    System.out.println(maxCountPage);
        } catch (Exception e){

        }

        Elements brandElements = doc1.getElementsByAttributeValue("name", "ms|vendor");
        String arr[] = String.valueOf(brandElements.get(0)).split("class=\"\">");
        ArrayList<String> brandList = new ArrayList<>();
        for (int i = 1; i < arr.length ; i++) {
            brandList.add(arr[i].split("&")[0]);
        }

        //      System.out.println(brandList);

        String link =  "";

        for (int v = 1; v <= maxCountPage; v++) {

            link = "https://sport-pitanie.com/gejneryi/?page="+ v +"&limit=48";
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
            Elements product = doc.getElementsByAttributeValue("class", "productCard_wrapper__item");
            Thread.sleep(1000);

            for (int i = 0; i < product.size(); i++) {

                String description = String.valueOf(product.get(i).getElementsByAttributeValue("class", "productCard_wrapper__item_description")).split("html\">")[1].split("</a>")[0].replaceAll(",", ".");

                //  System.out.println(String.valueOf(product.get(i).getElementsByAttributeValue("class", "productCard_wrapper__item_description")).split("html\">")[1].split("</a>")[0]);

                String brand = "";

                for(String x : brandList){
                    if (description.indexOf(x) != -1){
                        brand = x;
                        //         System.out.println(brand);
                    }
                }

                String price = String.valueOf(product.get(i).getElementsByAttributeValue("class", "productCard_wrapper__item_description_price price")).split("price\">")[1].split(" руб.")[0];
                //System.out.println(price);
                String priceAction = "";
                try {
                    price = String.valueOf(product.get(i).getElementsByAttributeValue("class", "productCard_wrapper__item_description_old_price old_price old_price__custom")).split("custom\">")[1].split(" руб.")[0];
                    priceAction = String.valueOf(product.get(i).getElementsByAttributeValue("class", "productCard_wrapper__item_description_price price")).split("price\">")[1].split(" руб.")[0];

                }catch (Exception e){

                }
/*                System.out.println(price);
                System.out.println(priceAction);*/


                String image = String.valueOf(product.get(i).getElementsByAttributeValue("class", "productCard_wrapper__item")).split("src=\"")[1].split("\" alt")[0].replaceAll(",", ".");
                String linkpProduct = String.valueOf(product.get(i).getElementsByAttributeValue("class", "productCard_wrapper__item")).split("href=\"")[1].split("\">")[0].replaceAll(",", ".");

                ArrayList<String> productList = new ArrayList<>();

                productList.add(namePortal);
                productList.add(nameProductGroup);
                productList.add(brand);
                productList.add(description);
                productList.add("Вес в описании");
                productList.add("Нет отсутствующих позиций");
                productList.add(price);
                productList.add(priceAction);
                productList.add("https://sport-pitanie.com/"+image);
                productList.add("https://sport-pitanie.com/"+linkpProduct);
                productList.add(sdfDate.format(nowTime));

                new WriterForOut().writeToFile(productList, "D:\\fizcult.csv");

            }


        }


    }


}
