package com.javarush.test.level35.lesson04.home01;

public class GenericStatic {


    public static <T extends Object> T someStaticMethod(Object genericObject) {
        System.out.println(genericObject);
        return (T) genericObject;
    }
}
