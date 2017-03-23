package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("F:\\fgg.txt");

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (inputStream.available() > 0){

            int symbol = inputStream.read();

            if(map.containsKey(symbol)){

                int count = map.get(symbol);
                map.put(symbol, count + 1);
            }
            else{
                map.put(symbol, 1);
            }
        }

        for(int i  = 0; i < 256; i++){

            if (map.containsKey(i)){

                System.out.println((char)i + " " + map.get(i));
            }
        }

        inputStream.close();

    }
}

