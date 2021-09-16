package com.parsing.gammaDotBy;

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

public class GammaByPreworkout {

    public GammaByPreworkout() throws IOException, InterruptedException {

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date nowTime = new Date();


        String namePortal = "gamma.by";
        String nameProductGroup = "Предтреники и энергетики";


        String linkProtein = "https://gamma.by/sportpit/preworkout/?limit=100&page=1";
        Thread.sleep(1000);

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

        int maxCountPage = Integer.parseInt(String.valueOf(countPage).split("\"")[String.valueOf(countPage).split("\"").length-2].split("=")[2]); //максимальное количество страниц

        //   System.out.println(maxCountPage);

        List<String> listLink = new ArrayList<>();
        String link =  "";

        for (int v = 1; v <= maxCountPage; v++) {
            //   System.out.println(i);
            link = "https://gamma.by/sportpit/preworkout/?limit=100&page=" + v;

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
            Elements product = doc.getElementsByAttributeValue("class", "product-thumb");
            Thread.sleep(1000);

            // System.out.println(product.get(0).getAllElements().get(5));


            for (int i = 0; i < product.size(); i++) {



                Element productBrandElement = product.get(i).getElementsByAttributeValue("class", "img-responsive").get(0);

                String brandStr = String.valueOf(productBrandElement).split("<img src=\"https://gamma.by/image/cache/catalog/image/cache/catalog/")[1].split("/")[0]; //бренд
                String productDescriptionStr = String.valueOf(productBrandElement).split("alt=\"")[1].replaceAll("\">", ""); //описание
                String image = String.valueOf(productBrandElement).split("\"")[1]; //фото
                //   Element productWeightElement1 = product.get(i).getElementsByAttributeValue("class", "img-hpm-col-model").get(0);

                String priceProduct1 = "";
                String priceProductAction1 = ""; //Цена по акции

                String weightElementsStr2 = "";
                String priceProduct2 = "";
                String priceProductAction2 = "";

                String weightElementsStr1 = "";

                try {

                    Elements weightElements = product.get(i).getElementsByAttributeValue("class", "hpm-cat-item active");
                    weightElementsStr1 = String.valueOf(weightElements.get(0)).split("\"hpm-col-model\">")[1].split("</d")[0].replaceAll("\n|  ","");


                    priceProduct1 = String.valueOf(weightElements.get(0)).split("data-price=\"")[1].split(" ")[0]; //Цена продукта 1


                    if (String.valueOf(weightElements.get(0)).indexOf("data-special") != -1){
                        priceProductAction1 = String.valueOf(weightElements.get(0)).split("data-special=\"")[1].split(" ")[0];
/*                    String temporary = priceProduct1; //меняем местами цены
                    priceProduct1 = priceProductAction1;
                    priceProductAction1 = temporary;*/
                    }
                } catch (Exception e){

                    //  System.out.println(product.get(i).getElementsByAttributeValue("class", "cat-box-effect").get(0));

                    if (String.valueOf(product.get(i).getElementsByAttributeValue("class", "cat-box-effect").get(0)).indexOf("common-price") != -1){
                        priceProduct1 = String.valueOf(product.get(i).getElementsByAttributeValue("class", "cat-box-effect").get(0)).split("common-price\">")[1].split(" ")[0];
                        //    System.out.println(priceProduct1);
                    } else if (String.valueOf(product.get(i).getElementsByAttributeValue("class", "cat-box-effect").get(0)).indexOf("price-new") != -1){
                        priceProduct1 = String.valueOf(product.get(i).getElementsByAttributeValue("class", "cat-box-effect").get(0)).split("price-old\">")[1].split(" ")[0];
                        priceProductAction1 = String.valueOf(product.get(i).getElementsByAttributeValue("class", "price").get(0)).split("price-new\">")[1].split(" ")[0];

                    }

                    //   priceProduct1 = String.valueOf(product.get(0).getElementsByAttributeValue("class", "hpm-cat-item ")

                }


                try {
                    Elements weightElements = product.get(i).getElementsByAttributeValue("class", "hpm-cat-item ");

                    priceProduct2 = String.valueOf(weightElements.get(0)).split("data-price=\"")[1].split(" ")[0]; //Цена продукта 2
                    if (String.valueOf(weightElements.get(0)).indexOf("data-special") != -1){
                        priceProductAction2 = String.valueOf(weightElements.get(0)).split("data-special=\"")[1].split(" ")[0];
/*                        String temporary = priceProduct2; //меняем местами цены
                        priceProduct2 = priceProductAction2;
                        priceProductAction2 = temporary;*/
                    }
                    weightElementsStr2 = String.valueOf(weightElements.get(0)).split("\"hpm-col-model\">")[1].split("</d")[0].replaceAll("\n|  ","");
                } catch (Exception e){

                }

                String stock1 = String.valueOf(product.get(i).getElementsByAttributeValue("class", "oct-product-stock").get(0)).split("<span>")[1].split("<")[0]; //Наличие на складе
                String linkProduct = String.valueOf(product.get(i).getElementsByAttributeValue("class", "image").get(0)).split("href=\"")[2].split("\"")[0]; //ссылка на фото

/*                System.out.println(linkProduct);
                System.out.println(stock1);
                System.out.println("Цена за продукт 1 "+priceProduct1);
                System.out.println("Цена за продукт 1 акция "+priceProductAction1);
                System.out.println("Вес 1 "+weightElementsStr1);

                System.out.println(brandStr);
                System.out.println(productDescriptionStr);
                System.out.println(image);

                System.out.println("Цена за продукт 2 "+ priceProduct2);
                System.out.println("Цена за продукт 2 акция "+priceProductAction2);
                System.out.println("Вес 2 "+weightElementsStr2);*/

                List<String> productList = new ArrayList<>();

                productList.add(namePortal);
                productList.add(nameProductGroup);
                productList.add(brandStr);
                if (weightElementsStr1.length() > 0) {
                    productList.add(productDescriptionStr.replaceAll(",",".") + " (" + weightElementsStr1 + ")");
                } else {
                    productList.add(productDescriptionStr.replaceAll(",","."));
                }
                productList.add("Вес в описании");
                productList.add(stock1);
                productList.add(priceProduct1);
                productList.add(priceProductAction1);
                productList.add(image);
                productList.add(linkProduct);
                productList.add(sdfDate.format(nowTime));

                new WriterForOut().writeToFile(productList, "D:\\fizcult.csv");

                if (weightElementsStr2.length() > 0) {
                    productList.clear();

                    productList.add(namePortal);
                    productList.add(nameProductGroup);
                    productList.add(brandStr);
                    productList.add(productDescriptionStr.replaceAll(",",".") + " (" + weightElementsStr2 + ")");
                    productList.add("Вес в описании");
                    productList.add(stock1);
                    productList.add(priceProduct2);
                    productList.add(priceProductAction2);
                    productList.add(image.replaceAll(",","."));
                    productList.add(linkProduct.replaceAll(",","."));
                    productList.add(sdfDate.format(nowTime));

                    new WriterForOut().writeToFile(productList, "D:\\fizcult.csv");

                }

            }

            product = doc.getElementsByAttributeValue("class", "product-thumb no_quantity");
            for (int i = 0; i < product.size(); i++) {



                Element productBrandElement = product.get(i).getElementsByAttributeValue("class", "img-responsive").get(0);

                String brandStr = String.valueOf(productBrandElement).split("<img src=\"https://gamma.by/image/cache/catalog/image/cache/catalog/")[1].split("/")[0]; //бренд
                String productDescriptionStr = String.valueOf(productBrandElement).split("alt=\"")[1].replaceAll("\">", ""); //описание
                String image = String.valueOf(productBrandElement).split("\"")[1]; //фото
                //   Element productWeightElement1 = product.get(i).getElementsByAttributeValue("class", "img-hpm-col-model").get(0);

                String priceProduct1 = "";
                String priceProductAction1 = ""; //Цена по акции

                String weightElementsStr2 = "";
                String priceProduct2 = "";
                String priceProductAction2 = "";

                String weightElementsStr1 = "";

                try {

                    Elements weightElements = product.get(i).getElementsByAttributeValue("class", "hpm-cat-item active");
                    weightElementsStr1 = String.valueOf(weightElements.get(0)).split("\"hpm-col-model\">")[1].split("</d")[0].replaceAll("\n|  ","");


                    priceProduct1 = String.valueOf(weightElements.get(0)).split("data-price=\"")[1].split(" ")[0]; //Цена продукта 1


                    if (String.valueOf(weightElements.get(0)).indexOf("data-special") != -1){
                        priceProductAction1 = String.valueOf(weightElements.get(0)).split("data-special=\"")[1].split(" ")[0];
/*                    String temporary = priceProduct1; //меняем местами цены
                    priceProduct1 = priceProductAction1;
                    priceProductAction1 = temporary;*/
                    }
                } catch (Exception e){

                    //  System.out.println(product.get(i).getElementsByAttributeValue("class", "cat-box-effect").get(0));

                    if (String.valueOf(product.get(i).getElementsByAttributeValue("class", "cat-box-effect").get(0)).indexOf("common-price") != -1){
                        priceProduct1 = String.valueOf(product.get(i).getElementsByAttributeValue("class", "cat-box-effect").get(0)).split("common-price\">")[1].split(" ")[0];
                        //    System.out.println(priceProduct1);
                    } else if (String.valueOf(product.get(i).getElementsByAttributeValue("class", "cat-box-effect").get(0)).indexOf("price-new") != -1){
                        priceProduct1 = String.valueOf(product.get(i).getElementsByAttributeValue("class", "cat-box-effect").get(0)).split("price-old\">")[1].split(" ")[0];
                        priceProductAction1 = String.valueOf(product.get(i).getElementsByAttributeValue("class", "price").get(0)).split("price-new\">")[1].split(" ")[0];

                    }

                    //   priceProduct1 = String.valueOf(product.get(0).getElementsByAttributeValue("class", "hpm-cat-item ")

                }


                try {
                    Elements weightElements = product.get(i).getElementsByAttributeValue("class", "hpm-cat-item ");

                    priceProduct2 = String.valueOf(weightElements.get(0)).split("data-price=\"")[1].split(" ")[0]; //Цена продукта 2
                    if (String.valueOf(weightElements.get(0)).indexOf("data-special") != -1){
                        priceProductAction2 = String.valueOf(weightElements.get(0)).split("data-special=\"")[1].split(" ")[0];
/*                        String temporary = priceProduct2; //меняем местами цены
                        priceProduct2 = priceProductAction2;
                        priceProductAction2 = temporary;*/
                    }
                    weightElementsStr2 = String.valueOf(weightElements.get(0)).split("\"hpm-col-model\">")[1].split("</d")[0].replaceAll("\n|  ","");
                } catch (Exception e){

                }

                String stock1 = String.valueOf(product.get(i).getElementsByAttributeValue("class", "oct-product-stock").get(0)).split("<span>")[1].split("<")[0]; //Наличие на складе
                String linkProduct = String.valueOf(product.get(i).getElementsByAttributeValue("class", "image").get(0)).split("href=\"")[2].split("\"")[0]; //ссылка на фото

/*                System.out.println(linkProduct);
                System.out.println(stock1);
                System.out.println("Цена за продукт 1 "+priceProduct1);
                System.out.println("Цена за продукт 1 акция "+priceProductAction1);
                System.out.println("Вес 1 "+weightElementsStr1);

                System.out.println(brandStr);
                System.out.println(productDescriptionStr);
                System.out.println(image);

                System.out.println("Цена за продукт 2 "+ priceProduct2);
                System.out.println("Цена за продукт 2 акция "+priceProductAction2);
                System.out.println("Вес 2 "+weightElementsStr2);*/

                List<String> productList = new ArrayList<>();

                productList.add(namePortal);
                productList.add(nameProductGroup);
                productList.add(brandStr);
                if (weightElementsStr1.length() > 0) {
                    productList.add(productDescriptionStr.replaceAll(",",".") + " (" + weightElementsStr1 + ")");
                } else {
                    productList.add(productDescriptionStr.replaceAll(",","."));
                }
                productList.add("Вес в описании");
                productList.add(stock1);
                productList.add(priceProduct1);
                productList.add(priceProductAction1);
                productList.add(image);
                productList.add(linkProduct);
                productList.add(sdfDate.format(nowTime));

                new WriterForOut().writeToFile(productList, "D:\\fizcult.csv");

                if (weightElementsStr2.length() > 0) {
                    productList.clear();

                    productList.add(namePortal);
                    productList.add(nameProductGroup);
                    productList.add(brandStr);
                    productList.add(productDescriptionStr.replaceAll(",",".") + " (" + weightElementsStr2 + ")");
                    productList.add("Вес в описании");
                    productList.add(stock1);
                    productList.add(priceProduct2);
                    productList.add(priceProductAction2);
                    productList.add(image.replaceAll(",","."));
                    productList.add(linkProduct.replaceAll(",","."));
                    productList.add(sdfDate.format(nowTime));

                    new WriterForOut().writeToFile(productList, "D:\\fizcult.csv");

                }

            }




        }

    }

}
