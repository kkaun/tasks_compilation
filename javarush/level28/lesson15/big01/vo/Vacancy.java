package com.javarush.test.level28.lesson15.big01.vo;

import java.util.Objects;

/**
 * Created by Кира on 15.11.2016.
 */
public class Vacancy {

    private String title;
    private String salary;
    private String city;
    private String companyName;
    private String siteName;
    private String url;

    @Override
    public int hashCode() {
        return Objects.hash(title, salary, city, companyName, siteName, url);
    }

    @Override
    public boolean equals(Object obj) {
        Vacancy n = (Vacancy) obj;

        if (this == n){
            return true;
        }

        if(n == null){
            return false;
        }

        if(this.getClass() != n.getClass()){
            return false;
        }

        return Objects.equals(title, n.title) && Objects.equals(salary, n.salary) && Objects.equals(city, n.city)
                && Objects.equals(companyName, n.companyName) && Objects.equals(siteName, n.siteName) && Objects.equals(url, n.url);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
