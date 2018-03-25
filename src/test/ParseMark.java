package test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParseMark {
    public static void main(String[] args) {
        Connection.Response connection = null;
        Connection.Response connection2 = null;
        String url = "";
        // Get authorization URL
        try {
            connection = Jsoup.connect("https://av.by/").execute();
            Document doc = connection.parse();
            Elements try2 = doc.select("div.listing-item-firm, div.listing-item");
            //option - тэг, который содержит текст "Марка автомобиля"
            Element try3 = doc.select("option:containsOwn(Марка автомобиля)").get(0);
            //возвращает братьев предыдушего тэга(то что мне нужно)
            Elements elements = try3.siblingElements();
            for(Element element:elements){
                System.out.print(element.text() + " ");
                System.out.println(element.attr("value"));
                connection2 = Jsoup.connect("https://cars.av.by/search?brand_id%5B%5D="  + element.attr("value") +  "&model_id%5B%5D=0&year_from=&year_to=&currency=USD&price_from=&price_to=").execute();
                Document document = connection2.parse();
                Element try4 = document.select("option:containsOwn(Модель)").get(0);
                Elements elements1 = try4.siblingElements();
                for(Element elements2: elements1){
                    System.out.print("    " + elements2.text());
                    System.out.println(" " + elements2.attr("value"));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
