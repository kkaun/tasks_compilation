package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        for (int j = 0; j < alphabet.size(); j++) {    //проходимся по массиву алфавита
            char ch = alphabet.get(j);                //присваиваем переменной char ch каждую букву алфавита
            int count = 0;                            //вводим переменную COUNT для определения кол-ва букв алфавита по номеру буквы в алфавите
            for (int k = 0; k < list.size(); k++) {       //проходимся циклом по вводу строк
                String s = list.get(k);                     //приваиваем переменной String s каждую из десяти строк
                for (int i = 0; i < s.length(); i++) {      //проходмся циклом по КАЖДОЙ ВВЕДЕННОЙ СТРОКЕ
                    if (ch == s.charAt(i)) {               //если буква из алфавита равна
                        count++;                          //тогда итерация переменной COUNT
                    }
                }
            }
            System.out.println(ch + " " + count);
        }

        }

    }

