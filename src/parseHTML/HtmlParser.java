package parseHTML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HtmlParser {
    public void parse() {
        Document doc;
        try {
            doc = Jsoup.connect("http://google.com/").get();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
