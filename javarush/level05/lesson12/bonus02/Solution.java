package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {

            list.add(Integer.parseInt(reader.readLine()));
        }

            int minimum = list.get(0);

            for (int j = 0; j < list.size(); j++) {
                if (minimum > list.get(j)) {
                    minimum = list.get(j);
                }
            }

            System.out.println("Minimum = " + minimum);
        }

    }

