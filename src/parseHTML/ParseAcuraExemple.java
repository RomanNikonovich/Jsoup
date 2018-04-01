package parseHTML;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parseHTML.entity.carForForm.ChooseCarsRealm;
import parseHTML.entity.carForForm.MakeCarRealm;
import parseHTML.entity.carForForm.ModelRealm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseAcuraExemple {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                Document docMake;
                Document docModel;
                try {
                    docMake = Jsoup
                            .connect("https://av.by/")
                            .get();

                    Element selectMake = docMake
                            .select("option:containsOwn(Марка автомобиля)")
                            .get(0);
                    Elements makes = selectMake.siblingElements();

                    List<MakeCarRealm> listMakes = new ArrayList<>();
                    MakeCarRealm makeCarRealm;

                    for (Element make : makes) {

                        makeCarRealm = new MakeCarRealm(make.text(), Integer.valueOf(make.attr("value")));
                        List<ModelRealm> listModels = new ArrayList<>();

                        docModel = Jsoup
                                .connect("https://cars.av.by/search?brand_id%5B%5D=" + make.attr("value") + "&model_id%5B%5D=0&year_from=&year_to=&currency=USD&price_from=&price_to=")
                                .get();

                        Element selectModel = docModel
                                .select("option:containsOwn(Модель)")
                                .get(0);
                        Elements models = selectModel.siblingElements();

                        for (Element model : models) {
                            ModelRealm modelRealm = new ModelRealm(model.text(), Integer.valueOf(model.attr("value")));
                            listModels.add(modelRealm);
                        }
                        makeCarRealm.setModelsCarsR(listModels);
                        listMakes.add(makeCarRealm);
                    }
                    ChooseCarsRealm carsRealm = new ChooseCarsRealm(listMakes);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
