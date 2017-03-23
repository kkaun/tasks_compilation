package com.javarush.test.level36.lesson08.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        File inc = new File(args[0]);

        try(BufferedReader reader = new BufferedReader(new FileReader(inc))){

            String text = "";

            while (reader.ready()) {
                text += reader.readLine();
            }

            reader.close();

            TreeSet<String> set = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);

            for(int i = 0; i < text.length(); i++){
                if(Character.isLetter(text.charAt(i))) {
                    set.add(String.valueOf(text.charAt(i)).toLowerCase());
                }
            }

            StringBuilder sb = new StringBuilder();

            Object[] fin = set.toArray();

            if(fin.length < 5) {

                for (Object s : fin) {
                    sb.append(s);
                }
            }else {

                for(int j = 0; j < 5; j++){
                    sb.append(fin[j]);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
