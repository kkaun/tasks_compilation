package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

import java.io.IOException;

/**
 * Created by Кира on 15.11.2016.
 */
public class Aggregator {

    public static void main(String[] args) throws IOException {

        HtmlView view = new HtmlView();
        Model model = new Model(view, new Provider[]{new Provider(new MoikrugStrategy())});
        Controller controller = new Controller(model);

        view.setController(controller);

        view.userCitySelectEmulationMethod();



    }
}
