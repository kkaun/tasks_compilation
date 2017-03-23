package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(args[0]);
        int count = 0;

        while (fis.available() > 0) {
            Character ch = (char)fis.read();
            if (String.valueOf(ch).matches("[a-zA-Z]")){
                count++;
            }
        }
        fis.close();
        System.out.println(count);
    }
}
