package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] stroka = new char[s.length()]; // Создаём массив чар, в который перенесём строку
        ArrayList<String> glas = new ArrayList<>(); // Создаю аррэй для гласных
        ArrayList<String> soglas = new ArrayList<>(); // Создаю аррэй для согласных

        for (int i = 0; i < s.length(); i++) {
            stroka[i] = s.charAt(i);  // В этом цикле переношу всё из строки s в чар массив
        }
        String temp = " ";  // создал стринг с пробелом
        char probel = temp.charAt(0); //и вставил пробел в чар переменную
        // что бы в результате не было двойных пробелов (М м  м л  р м .) - нужно их удалить.
        for (int i = 0; i < stroka.length; i++)  { //начинаем перенос каждого чара в соответствующий список
            if (stroka[i] == probel)
            continue;// если текущий чар это пробел - пропускаем чар
            else {                                                     // Если не пробел - распределяем по спискам
                if (isVowel(stroka[i]))
                    glas.add(String.valueOf(stroka[i]));                              //если гласная - в гласные
                else
                    soglas.add(String.valueOf(stroka[i]));                              //если согласная - в согласные
            }
        }
        for (int i = 0, glasSize = glas.size(); i < glasSize; i++) {
            String a = glas.get(i);
            System.out.print(a + " "); //выводим на экран глассные
        }
        System.out.println();
        for (int i = 0, soglasSize = soglas.size(); i < soglasSize; i++) {
            String a = soglas.get(i);
            System.out.print(a + " ");//выводим на экран соглассные
        }
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
