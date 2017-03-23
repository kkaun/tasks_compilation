package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        TreeMap<String, Double> map = new TreeMap<>();

        String name;

        while ((name = reader.readLine()) != null) {

            String[] s = name.split(" ");

            if (!map.containsKey(s[0])) {

                map.put(s[0], Double.parseDouble(s[1]));
            } else {

                map.put(s[0], map.get(s[0]) + Double.parseDouble(s[1]));

            }
        }

        double max = Double.MIN_VALUE;

        for(Map.Entry<String, Double> ll : map.entrySet()){

            max = Math.max(max, ll.getValue());
        }
        for (Map.Entry< String, Double > pair : map.entrySet())
        {
            if (pair.getValue().equals(max))
            {
                System.out.println(pair.getKey());
            }
        }

        reader.close();

        }
    }

