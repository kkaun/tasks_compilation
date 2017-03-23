package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader((new File(args[0]))));

        BufferedWriter writer = new BufferedWriter(new FileWriter((new File(args[1]))));

        while (reader.ready()) {
            String readedString = reader.readLine();
            String[] readedWords  = readedString.split(" ");
            for (int i = 0; i < readedWords.length; i++) {
                Pattern pattern = Pattern.compile("[0-9]");
                Matcher matcher = pattern.matcher(readedWords[i]);
                if (matcher.find()) {
                    writer.write(readedWords[i] + " ");
                }


            }

            System.out.println(readedWords);
        }
        reader.close();
        writer.close();

    }
}
