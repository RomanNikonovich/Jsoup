package parseHTML;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Connection.Response connection = null;
        String url = "";
        // Get authorization URL
        try {
            connection = Jsoup.connect("https://cars.av.by/search?brand_id%5B0%5D=1444&model_id%5B0%5D=0&year_from=&year_to=&currency=USD&price_from=&price_to=").execute();
            Document doc = connection.parse();
        /*    Elements links = doc.getElementsByClass("listing-item listing-item-firm");
            Elements title = links.tagName("a[href]"); */
            /*System.out.println(title.get(0).attributes());
            System.out.println(title.get(1).text());*/
            Elements try2 = doc.select("div.listing-item-firm, div.listing-item");
            for(Element element:try2){
                System.out.println("название авто: " + element.select("h4>a[href]").text());
                System.out.println("ссылка на авто: " + element.select("h4>a[href]").attr("href"));
                System.out.println("цена: " + element.select("strong").get(0).text());
            }
           /* Element link2 = try2.select("a[href]").get(1);
            Element link3 = try2.select("strong").get(0);
            System.out.println(link2.text());
            System.out.println(link2.attr("href"));
            System.out.println(link3.text());*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
