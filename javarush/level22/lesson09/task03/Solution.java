package com.javarush.test.level22.lesson09.task03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        String file;
        Scanner scanner = new Scanner(System.in);

        file = scanner.nextLine();

        scanner.close();

        String s = "";

        Scanner sc = new Scanner(new File(file));

        while (sc.hasNext()){
            s += sc.next() + " ";
        }

        sc.close();

        String[] words = s.split(" ");

        //...
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        if (words == null || words.length == 0)
        {
            return new StringBuilder();
        }

        if (words.length == 1)
        {
            return new StringBuilder(words[0]);
        }

        StringBuilder result = new StringBuilder();

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < words.length; i ++)
                list.add(words[i]);

        while (!isOK(list))
        {
            Collections.shuffle(list);
        }

        for (String s : list)
            result.append(s+ " ");
        result.deleteCharAt(result.length()-1);
        return result;

    }

    private static boolean isOK(ArrayList<String> list) {

        for (int i = 0; i < list.size()-1; i++)
        {
            String first = list.get(i);
            String second = list.get(i+1);
            first = first.toLowerCase();
            second =second.toLowerCase();
            if (first.charAt(first.length()-1)!=second.charAt(0))
                return false;
        }
        return true;
    }


}
