package com.parsing.aminosDotBy;

import com.parsing.csv.WriterForOut;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AminoByKreatin {

    public AminoByKreatin() throws IOException, InterruptedException {

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date nowTime = new Date();


        String namePortal = "aminos.by";
        String nameProductGroup = "Креатин";


        String linkProtein = "https://aminos.by/kreatin/?page=1&limit=100";


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
        Elements countPage = doc1.getElementsByAttributeValue("class", "results");

        //  System.out.println(String.valueOf(countPage).split(": ", 2)[1].split("\\)", 2)[0]);

        int maxCountPage = Integer.parseInt(String.valueOf(countPage).split(": ", 2)[1].split("\\)", 2)[0]); //максимальное количество страниц

      //  System.out.println(maxCountPage);

        List<String> listLink = new ArrayList<>();
        String link =  "";

        for (int v = 1; v <= maxCountPage; v++) {
            //   System.out.println(i);
            link = "https://aminos.by/kreatin/?page="+v+"&limit=100";

        //    System.out.println(link);

            Thread.sleep(1000);
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
            Elements product = doc.getElementsByAttributeValue("class", "thumbnail product-thumb");


            // System.out.println(product.get(0).getAllElements().get(5));


            for (int i = 0; i < product.size(); i++) {

                Element productBrandElement = product.get(i).getElementsByAttributeValue("class", "product-series").get(0);

                Elements productNameElement = product.get(i).getElementsByAttributeValue("class", "img-responsive img-thumbnail-transparent");
                //   Element productBrandElement2 = product.get(i).getElementsByAttributeValue("");

                String arrProduct [] = String.valueOf(productNameElement.get(0)).split("\"");

                String brand =  String.valueOf(productBrandElement).split("<|>")[2]; //брэнд

                String productDescription = arrProduct[3]; //описание

                String weight = "Вес в описании";

                Element stockElement = product.get(i).getElementsByAttributeValue("class", "stock").get(0);

                String stock =  String.valueOf(stockElement).split("<|>")[2].replaceAll("\n",""); //наличие

                Element priceElement = product.get(i).getElementsByAttributeValue("class", "product-price").get(0);

                String price =  String.valueOf(priceElement).split("<|>")[2].replaceAll("\n| руб",""); //цена

                Element priceActionElement = null;
                String priceAction = "";

                try {
                    priceActionElement = product.get(i).getElementsByAttributeValue("class", "product-old-price").get(0);
                    priceAction =  String.valueOf(priceActionElement).split("<|>")[2].replaceAll("\n| руб",""); //цена по акции

                    String temporary = price; //меняем местами цены
                    price = priceAction;
                    priceAction = temporary;

                } catch (Exception e) {

                }

                String linkImg = arrProduct[1]; //ссылка на фото

                Element linkProductElement = product.get(i).getElementsByAttributeValue("class", "product-thumb-img").get(0);

                String linklinkProduct = String.valueOf(linkProductElement).split("\"")[3]; //ссылка на карточку продукта


                List<String> productList = new ArrayList<>();

                productList.add(namePortal);
                productList.add(nameProductGroup);
                productList.add(brand);
                productList.add(productDescription.replaceAll(",",""));
                productList.add(weight);
                productList.add(stock);
                productList.add(price);
                productList.add(priceAction);
                productList.add(linkImg.replaceAll(",",""));
                productList.add(linklinkProduct.replaceAll(",",""));
                productList.add(sdfDate.format(nowTime));

                new WriterForOut().writeToFile(productList, "D:\\fizcult.csv");


            }


        }

    }


}
