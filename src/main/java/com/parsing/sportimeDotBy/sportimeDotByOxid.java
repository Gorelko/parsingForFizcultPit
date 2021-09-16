package com.parsing.sportimeDotBy;

import com.parsing.csv.WriterForOut;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class sportimeDotByOxid {

    public sportimeDotByOxid() throws IOException, InterruptedException {

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date nowTime = new Date();


        String namePortal = "sportime.by";
        String nameProductGroup = "Оксид азота";


        Document doc1 = null;
        while (true) {
            try {

                String link = "http://sportime.by/oxid-azota";
                doc1 = Jsoup.connect(link).get();
                Thread.sleep(1000);
                break;
            }catch (Exception e){
                System.out.println("Обрыв коннекта, подключаемся! Возможная причина - отсутствие интернета или сайт не работает!");
                Thread.sleep(3000);
            }
        }


        //System.out.println(listBrand);

        int countPage = 1;

        try {
            //System.out.println(doc1.getElementsByAttributeValue("class","paginator__btn paginator__btn_last"));
            countPage = Integer.parseInt(String.valueOf(doc1.getElementsByAttributeValue("class","pager-last last")).split("page=")[1].split("\">")[0]);
        }catch (Exception e){

        }
        //System.out.println(countPage);

        //System.out.println(String.valueOf(doc1.getElementsByAttributeValue("class","paginator__btn paginator__btn_last")).split("=")[String.valueOf(doc1.getElementsByAttributeValue("class","paginator__btn paginator__btn_last")).split("=").length-3].split("&")[0]);

        for (int x = 0; x <= countPage; x++) {

            Thread.sleep(1000);
            Document doc = null;
            while (true) {
                try {
                    if (x==0){
                        doc = Jsoup.connect("http://sportime.by/oxid-azota").get();
                    }else {
                        doc = Jsoup.connect("http://sportime.by/oxid-azota?page="+ x).get();
                    }
                    Thread.sleep(1000);
                    break;
                }catch (Exception e){
                    System.out.println("Обрыв коннекта, подключаемся! Возможная причина - отсутствие интернета или сайт не работает!");
                    Thread.sleep(3000);
                }
            }
            Thread.sleep(1000);
            Elements product = doc.getElementsByAttributeValueStarting("class","row anons-tovar"); //.getElementsByAttributeValue("class","product-layout product-grid");


            for (int i = 0; i < product.size(); i++) {
                //System.out.println(String.valueOf(product.get(i).getElementsByAttributeValue("class","large-9 columns")).split("href=\"")[1].split("\">")[0]);
                String linkProduct = "http://sportime.by" + String.valueOf(product.get(i).getElementsByAttributeValue("class","large-9 columns")).split("href=\"")[1].split("\">")[0];
                //System.out.println(linkProduct);

                String nameBrand = "";
                String description = "";
                String weight = "";
                String store = "В наличии";
                String priceOld = "";
                String priceNew = "";
                String photo = "";
                String link = linkProduct;


                Document doc2 = null;
                while (true) {
                    try {
                        doc2 = Jsoup.connect(linkProduct).get();
                        Thread.sleep(1000);
                        try {
                            nameBrand = String.valueOf(doc2.getElementsByAttributeValueStarting("class","field field-name-field-brand").get(0)).split("even\">")[1].split("</div>")[0].replaceAll("\n", "");
                        }catch (Exception e){

                        }

                        try {
                            description = String.valueOf(doc2.getElementsByAttributeValueStarting("class","page-title").get(0)).split("page-title\">")[1].split("</h1>")[0].replaceAll("\n", "");
                        }catch (Exception e){

                        }

                        try {
                            weight = String.valueOf(doc2.getElementsByAttributeValueStarting("class","field field-name-field-vespitania").get(0)).split("even\">")[1].split("</div>")[0].replaceAll("\n", "");
                        }catch (Exception e){

                        }

                        try {
                            store = String.valueOf(doc2.getElementsByAttributeValueStarting("class","field field-name-field-sold").get(0)).split("even\">")[1].split("</div>")[0].replaceAll("\n", "");
                        }catch (Exception e){

                        }

                        try {
                            if (store.equals("В наличии")){
                                priceOld = String.valueOf(doc2.getElementsByAttributeValueStarting("class", "price-amount").get(0)).split("amount\">")[1].split("</td>")[0].replaceAll("\n", "");
                            }else {
                                priceOld="";
                            }
                        }catch (Exception e){

                        }

                        try {
                            if (store.equals("В наличии")) {
                                priceNew = String.valueOf(doc2.getElementsByAttributeValueStarting("class", "price-amount").get(1)).split("amount\">")[1].split("</td>")[0].replaceAll("&nbsp;", "");
                            } else {
                                priceNew="";
                            }
                        }catch (Exception e){

                        }

                        try {
                            photo = String.valueOf(doc2.getElementsByAttributeValueStarting("typeof","foaf:Image").get(0)).split("src=\"")[1].split("\" ")[0].replaceAll("\n", "");
                        }catch (Exception e){

                        }


                        break;
                    }catch (Exception e){
                        System.out.println("Обрыв коннекта, подключаемся! Возможная причина - отсутствие интернета или сайт не работает!");
                        Thread.sleep(3000);
                    }
                }
/*                System.out.println(nameBrand.replaceAll("   ", "").replaceAll(",", "."));
                System.out.println(description.replaceAll(",", "."));
                System.out.println(weight.replaceAll("   ", "").replaceAll(",", "."));
                System.out.println(store.replaceAll("   ", ""));
                System.out.println(priceOld.replaceAll("&nbsp;", "").replaceAll(",", "."));
                System.out.println(priceNew.replaceAll(",", "."));
                System.out.println(photo.replaceAll(",", "."));
                System.out.println(link.replaceAll(",", "."));*/


                List<String> productList = new ArrayList<>();

                productList.add(namePortal);
                productList.add(nameProductGroup.replaceAll(";", "."));
                productList.add(nameBrand.replaceAll("   ", "").replaceAll(";", "."));
                productList.add(description.replaceAll(";", "."));
                productList.add(weight.replaceAll("   ", "").replaceAll(";", "."));
                productList.add(store.replaceAll("   ", ""));
                productList.add(priceOld.replaceAll("&nbsp;", "").replaceAll(";", "."));
                productList.add(priceNew.replaceAll(";", "."));
                productList.add(photo.replaceAll(";", "."));
                productList.add(link.replaceAll(";", "."));
                productList.add(sdfDate.format(nowTime));


                String allInform = "";
                for (int j = 0; j < productList.size(); j++) {
                    if (j!=productList.size()-1){
                        allInform = allInform + ";" + productList.get(j);
                    } else {
                        allInform = allInform + ";" + productList.get(j)  + ";" ;
                    }
                }

                List<String> productList2 = new ArrayList<>();
                productList2.add(allInform);

                // System.out.println(productList);
                new WriterForOut().writeToFile(productList2, "D:\\fizcult.csv");


            }




        }

    }

}
