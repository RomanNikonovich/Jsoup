package parseHTML.parseCars;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseUrl {
    public static List<Car> getCars(String url) throws IOException {
        List<Car> carsList = new ArrayList();
        Document docCars = Jsoup
                .connect(url)
                .get();
        Elements cars = docCars
                .select("div.listing-item-firm, div.listing-item");
        Elements urlPages = docCars
                .select("li.pages-numbers-item");
        if (urlPages.size() != 0) {
            carsList.addAll(parsePage(cars));
            for (int i = 1; i < urlPages.size(); i++) {
                carsList.addAll(parsePages(urlPages.get(i).select("a[href]").attr("href")));
            }
        } else {
            carsList.addAll(parsePage(cars));
        }
        return carsList;
    }

    private static List<Car> parsePages(String urlP) throws IOException {
        Document docCarsPage = Jsoup
                .connect(urlP)
                .get();
        Elements cars = docCarsPage
                .select("div.listing-item-firm, div.listing-item");
        return parsePage(cars);
    }

    private static List<Car> parsePage(Elements cars) {
        List<Car> carsList = new ArrayList();
        for (Element car : cars) {
            Car car1 = new Car();
            car1.setCarMake(car.select("h4>a[href]").text());
            car1.setLink(car.select("h4>a[href]").attr("href"));
            car1.setPriceRUB(car.select("strong").get(0).text());
            car1.setPriceUSD(car.select("small").get(0).text());
            carsList.add(car1);
           /* System.out.println("название авто: " + car.select("h4>a[href]").text());
            System.out.println("ссылка на авто: " + car.select("h4>a[href]").attr("href"));
            System.out.println("цена: " + car.select("strong").get(0).text());
            System.out.println("цена USD: " + car.select("small").get(0).text());*/
        }
        return carsList;
    }
}
