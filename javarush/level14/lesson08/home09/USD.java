package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Кира on 21.04.2016.
 */
public class USD extends Money {

    public USD(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "USD";
    }
}
