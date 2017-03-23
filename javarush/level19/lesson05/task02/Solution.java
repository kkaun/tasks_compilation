package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();

        reader.close();

        Scanner sc = new Scanner(new FileReader(file));

        String buffer;

        int count = 0;

        while (sc.hasNext()){

            String [] s = sc.nextLine().split("[., !?;:-]");

            for (String element: s) {
                if(element.equals("world"))
                    count++;
            }


        }

        System.out.println(count);

        sc.close();

    }
}
