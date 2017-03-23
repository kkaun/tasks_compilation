package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Кира on 21.04.2016.
 */
public class Singleton {

    private final static Singleton turtle = new Singleton();

    private Singleton(){

    }
    public static Singleton getInstance(){
        return turtle;
    }
}
