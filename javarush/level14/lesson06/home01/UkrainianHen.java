package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Кира on 19.04.2016.
 */
public class UkrainianHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 13;
    }

    String getDescription() {
        return super.getDescription() + (" Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
