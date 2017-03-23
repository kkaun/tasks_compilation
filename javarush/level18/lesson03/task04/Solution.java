package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> list = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        while(fileInputStream.available() > 0){
            int key = fileInputStream.read();
            if(list.containsKey(key)){
                int value = list.get(key);
                list.put(key, ++value);
            }
             else
            list.put(key, 1);
        }

        fileInputStream.close();
        reader.close();

        int tempValue = 127;
        for(Map.Entry <Integer, Integer> l : list.entrySet()){
            if(tempValue > l.getValue()){
                tempValue = l.getValue();
            }
        }
        for(Map.Entry<Integer, Integer> l : list.entrySet()){
            if (l.getValue() == tempValue)
                System.out.print(l.getKey() + " ");
        }
    }
}
