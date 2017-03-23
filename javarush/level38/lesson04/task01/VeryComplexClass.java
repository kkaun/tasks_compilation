package com.javarush.test.level38.lesson04.task01;

/* Проверяемые исключения (checked exception)
Напиши реализацию метода veryComplexMethod().
Он должен всегда кидать какое-нибудь проверяемое исключение.
Кинуть исключение (throw) явно нельзя.
*/

import java.io.BufferedReader;
import java.io.FileReader;

public class VeryComplexClass {

    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код

        FileReader s = new FileReader(" ");
        BufferedReader reader = new BufferedReader(s);

        reader.read();
    }
}
