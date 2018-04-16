package parseHTML.parseCars;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class ParseAcuraExemple {
    public static void main(String[] args) {
        Connection.Response connection = null;
        String url = "";
        // Get authorization URL
        try {
            List<Car> cars = ParseUrl.getCars("https://cars.av.by/search?brand_id%5B0%5D=1444&model_id%5B0%5D=&year_from=2004&year_to=2018&currency=USD&price_from=&price_to=&body_id=&engine_volume_min=&engine_volume_max=&driving_id=&mileage_min=&mileage_max=&region_id=&interior_material=&interior_color=&exchange=&search_time=");
            String s = "asdf";
           /* connection = Jsoup.connect("https://cars.av.by/search?brand_id%5B0%5D=1444&model_id%5B0%5D=&year_from=2004&year_to=2018&currency=USD&price_from=&price_to=&body_id=&engine_volume_min=&engine_volume_max=&driving_id=&mileage_min=&mileage_max=&region_id=&interior_material=&interior_color=&exchange=&search_time=").execute();
            Document doc = connection.parse();
        *//*    Elements links = doc.getElementsByClass("listing-item listing-item-firm");
            Elements title = links.tagName("a[href]");

            System.out.println(title.get(0).attributes());
            System.out.println(title.get(1).text());*//*

            //выбирает все элементы с тэгом div у которого значения класса = listing-item
            //через запятую выберет несколько значений
            Elements try2 = doc.select("div.listing-item-firm, div.listing-item");
            for (Element element : try2) {
                System.out.println("название авто: " + element.select("h4>a[href]").text());
                System.out.println("ссылка на авто: " + element.select("h4>a[href]").attr("href"));
                System.out.println("цена: " + element.select("strong").get(0).text());
                System.out.println("цена USD: " + element.select("small").get(0).text());

            }
         *//*   System.out.println("page: " + doc.select("li.pages-arrows-index").text());*//*
            Elements linkPage = doc.select("li.pages-numbers-item");
            for (Element link : linkPage) {
                System.out.println("page count: " + link.select("a[href]").attr("href"));
            }

            *//*Elements p2 = doc.select("li.pages-arrows-index").text();*//*

        *//*    Element link2 = try2.select("a[href]").get(1);
            Element link3 = try2.select("strong").get(0);
            System.out.println(link2.text());
            System.out.println(link2.attr("href"));
            System.out.println(link3.text());*//*
*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}