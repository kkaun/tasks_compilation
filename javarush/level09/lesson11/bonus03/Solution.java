package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
            String x = array[i];
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {

        for (int j = 0; j < array.length; j++)   //цикл для ввода
        {
            String bufferString;
            for (int i = 0; i < array.length - 1; i++) //цикл для неопред. переменной
            {
                int m = 1;
                if (!isNumber(array[i]))    //если не число
                {
                    while (true) {
                        if (i + m == array.length)      //если цикл достиг размера массива
                        {
                            bufferString = "";     //буфер вывода равен ""
                            break;
                        }
                        bufferString = array[i + m];    //до тех пор пока цикл не достиг размера массива
                        if (isNumber(bufferString) || bufferString.equals(""))  //а так же если буфер равен числу или ""
                        {
                            m++;
                            continue;                                           //цикл продолжается
                        } else {
                            break;
                        }
                    }
                    if (bufferString.equals("")) {
                        continue;
                    }
                    if (isGreaterThan(array[i], bufferString)) {
                        array[i + m] = array[i];
                        array[i] = bufferString;
                    }
                }
                else {                                                     //если число

                    while (true) {
                        if (i + m == array.length) {
                            bufferString = "";
                            break;
                        }
                        bufferString = array[i + m];
                        if (!isNumber(bufferString) || bufferString.equals("")) {
                            m++;
                            continue;
                        } else {
                            break;
                        }
                    }
                    if (bufferString.equals("")) {
                        continue;
                    }
                    if (Integer.parseInt(array[i]) < Integer.parseInt(bufferString)) {
                        array[i + m] = array[i];
                        array[i] = bufferString;
                    }
                }
            }
        }
    }


    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
