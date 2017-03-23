package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(bufferedReader.readLine()))) {
            String line;

            while ((line = br.readLine()) != null) {
                // process the line.
                try
                {
                    int n = Integer.parseInt(line);

                    list.add(n);
                }
                catch(NumberFormatException e)
                {
                    e.printStackTrace();
                }

            }
        }

        int[] arr = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }

        List<Integer> even = new ArrayList<Integer>();
        for (int i : arr) {
            if ((i & 1) == 0) {
                even.add(i);
            }
        }

        Collections.sort(even);

        for(int n = 0; n < even.size(); n++){
            System.out.println(even.get(n));
        }
    }
}
