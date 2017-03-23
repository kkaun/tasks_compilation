package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

/**
 * Created by Кира on 23.11.2016.
 */
public class HtmlView implements View {

    private Controller controller;

    private final String filePath = "./src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/") + "/vacancies.html";

    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            System.out.println("Some exception occurred");
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException {

        Document doc = Jsoup.parse(new File(filePath),"UTF-8");
        return doc;
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException {

        Document doc = getDocument();

        Element element = doc.getElementsByClass("template").first();
        Element cloneElement = element.clone();
        cloneElement.removeClass("template").removeAttr("style");

        doc.getElementsByAttributeValue("class","vacancy").remove();

        for(Vacancy v : vacancies){

            Element newVac = cloneElement.clone();

            doc.getElementsByAttributeValue("class", "city").get(0).text(v.getCity());
            doc.getElementsByAttributeValue("class", "companyName").get(0).text(v.getCompanyName());
            doc.getElementsByAttributeValue("class", "salary").get((0)).text(v.getSalary());
            Element link = newVac.getElementsByTag("a").get(0);
            link.text(v.getTitle());
            link.attr("href", v.getUrl());

            element.before(newVac.outerHtml());
        }

        return doc.html();
    }


    private void updateFile(String data) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter pw = new PrintWriter( new OutputStreamWriter( new FileOutputStream(filePath), "UTF-8"));
        pw.write(data);
        pw.close();

    }

    public void userCitySelectEmulationMethod() throws IOException {

        controller.onCitySelect("Moscow");

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
