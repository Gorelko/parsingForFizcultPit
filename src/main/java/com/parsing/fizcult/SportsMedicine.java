package com.parsing.fizcult;

import com.parsing.csv.WriterForOut;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SportsMedicine {

    public SportsMedicine() throws IOException, InterruptedException {

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date nowTime = new Date();



        String namePortal = "Fizcult";
        String nameProductGroup = "Спортивная медицина";



        String link1 = "https://fizcult.by/catalog/sportivnaya-medicina/?PAGEN_1=1&MUL_MODE=";
        List<String> listLink = new ArrayList();
        listLink.add(link1);

        Document doc1 = null;
        while (true) {
            try {

                String link = "https://fizcult.by/catalog/sportivnaya-medicina/?PAGEN_1=1&MUL_MODE=";
                doc1 = Jsoup.connect(link).get();
                Thread.sleep(1000);
                break;
            }catch (Exception e){
                System.out.println("Обрыв коннекта, подключаемся! Возможная причина - отсутствие интернета или сайт не работает!");
                Thread.sleep(3000);
            }
        }

        String arr[] = String.valueOf(doc1.getElementsByAttributeValue("class","tag__base").get(0)).split("tag__item\">");
        ArrayList<String> listBrand = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            listBrand.add(arr[i].split("</a>")[0]);
        }
        //System.out.println(listBrand);

        int countPage = 1;

        try {
            //System.out.println(doc1.getElementsByAttributeValue("class","paginator__btn paginator__btn_last"));
            countPage = Integer.parseInt(String.valueOf(doc1.getElementsByAttributeValue("class","paginator__btn paginator__btn_last")).split("=")[String.valueOf(doc1.getElementsByAttributeValue("class","paginator__btn paginator__btn_last")).split("=").length-3].split("&")[0]);
        }catch (Exception e){

        }


        //System.out.println(String.valueOf(doc1.getElementsByAttributeValue("class","paginator__btn paginator__btn_last")).split("=")[String.valueOf(doc1.getElementsByAttributeValue("class","paginator__btn paginator__btn_last")).split("=").length-3].split("&")[0]);

        for (int x = 1; x <= countPage; x++) {

            Thread.sleep(1000);
            Document doc = null;
            while (true) {
                try {
                    doc = Jsoup.connect("https://fizcult.by/catalog/sportivnaya-medicina/?PAGEN_1="+x+"&MUL_MODE=").get();
                    Thread.sleep(1000);
                    break;
                }catch (Exception e){
                    System.out.println("Обрыв коннекта, подключаемся! Возможная причина - отсутствие интернета или сайт не работает!");
                    Thread.sleep(3000);
                }
            }
            Thread.sleep(1000);
            Elements product = doc.getElementsByAttributeValue("class","product__box");

            //System.out.println(String.valueOf(doc.getElementsByAttributeValue("class","product__link").get(1)));


            for (int i = 0; i < product.size(); i++) {

                Elements productNameElement = product.get(i).getElementsByAttributeValue("class","product__title");
                Elements productWeigtElement = product.get(i).getElementsByAttributeValue("class","product__weight");
                Elements productPriceElement = product.get(i).getElementsByAttributeValue("class","product__cost");
                Elements productImageElement = product.get(i).getElementsByAttributeValue("class","product__img ");
                //System.out.println(productPriceElement);

                String linkBranf = "";
                try {
                    linkBranf = "https://fizcult.by/" + String.valueOf(product.get(i).getElementsByAttributeValue("class","product__link").get(0)).split("<a href=\"/")[1].split("\" onclick=")[0];
                }catch (Exception e) {

                }

                String productNameElementString = String.valueOf(productNameElement.get(0).getAllElements()).replaceAll("<h3 class=\"product__title\"> ", "").replaceAll(" </h3>", "");

                String brendName = "";
                for (int j = 0; j < listBrand.size(); j++) {
                    if (productNameElementString.toUpperCase().indexOf(listBrand.get(j).split(" ")[0].toUpperCase()) != -1){
                        brendName = listBrand.get(j);
                    } else {

                    }
                }


                String productWeigtElementString = "";


                try {
                    productWeigtElementString = String.valueOf(productWeigtElement.get(0).getAllElements()).replaceAll("<div class=\"product__weight\">", "").replaceAll("</div>", "").replaceAll("  ", "").replaceAll("\\n", "");
                } catch (Exception e){
                    productWeigtElementString = "тара не указана";
                }

                String productPriceElementString = "";
                String productPriceElementStringNew = "";
                try {
                    productPriceElementString = String.valueOf(productPriceElement.get(0).getAllElements()).split("product__price \">")[1].split(" руб.")[0];
                } catch (Exception e){
                    productPriceElementString = String.valueOf(productPriceElement.get(0).getAllElements()).split("price_old\">")[1].split(" руб.")[0];
                    productPriceElementStringNew = String.valueOf(productPriceElement.get(0).getAllElements()).split("price_new \">")[1].split(" руб.")[0];
                }


                String productImageElementString = "https://fizcult.by" + String.valueOf(productImageElement.get(0).getAllElements()).split("src=\"")[1].split("\"")[0];

                List<String> productList = new ArrayList<>();
                productList.add(namePortal);
                productList.add(nameProductGroup.replaceAll(",", "."));
                productList.add(brendName.replaceAll(",", "."));
                productList.add(productNameElementString.replaceAll(",", "."));
                productList.add(productWeigtElementString.replaceAll(",", "."));
                productList.add("В наличии");
                productList.add(productPriceElementString.replaceAll(",", "."));
                productList.add(productPriceElementStringNew);
                productList.add(productImageElementString.replaceAll(",", "."));
                productList.add(linkBranf.replaceAll(",", "."));
                productList.add(sdfDate.format(nowTime));

                new WriterForOut().writeToFile(productList, "D:\\fizcult.csv");

            }
        }
    }
}

