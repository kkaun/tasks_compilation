package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = bufferedReader.readLine();
        String fileOut = bufferedReader.readLine();
        FileReader reader = new FileReader(fileIn);
        FileWriter writer = new FileWriter(fileOut);
        String line = "";
        while (reader.ready())

        {
            int data = reader.read();
            char symbol = (char) data;
            line += symbol;
        }

        String words = line.replace(".", "!");

        writer.write(words);

        bufferedReader.close();
        reader.close();
        writer.close();

    }
}
