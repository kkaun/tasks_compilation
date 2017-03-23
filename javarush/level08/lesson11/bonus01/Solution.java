package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> mapp = new HashMap<String, Integer>();
        mapp.put("January", 1);
        mapp.put("February", 2);
        mapp.put("March", 3);
        mapp.put("April", 4);
        mapp.put("May", 5);
        mapp.put("June", 6);
        mapp.put("July", 7);
        mapp.put("August", 8);
        mapp.put("September", 9);
        mapp.put("October", 10);
        mapp.put("November", 11);
        mapp.put("December", 12);
        String month = reader.readLine();

        System.out.println(month + " is " + mapp.get(month) + " month");
    }
}



