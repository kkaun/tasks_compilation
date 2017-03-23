package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();

        FileReader reader = new FileReader(file1);
        FileWriter writer = new FileWriter(file2);

        String newtext = "";

        while(reader.ready()){

            int data = reader.read();

            char text = (char)data;

            newtext += text;
        }

        String[] words = newtext.split("[\\W\\s\\n]");

        for(String word : words) {
            if (word.matches("[A-Za-z0-9]+")) {
                writer.write(word);
            }
        }

        bufferedReader.close();
        reader.close();
        writer.close();
    }
}
