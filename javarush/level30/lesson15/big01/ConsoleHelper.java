package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Кира on 16.11.2016.
 */
public class ConsoleHelper {


    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int readInt(){

        int n = 0;

        do {
            try {
                n = Integer.parseInt(readString());
            } catch (NumberFormatException e) {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
                n = Integer.parseInt(readString());
            }
            return n;

        }while (true);
    }

    public static String readString(){

        String s = null;

        do {
            try {
                s = reader.readLine();
            } catch (IOException e) {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
                continue;
            }
            return s;

        }while (true);

    }

    public static void writeMessage(String message){

        System.out.println(message);
    }


}
