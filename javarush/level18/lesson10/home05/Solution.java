package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        Scanner scanner = new Scanner(new FileReader(file1)).useLocale(Locale.ENGLISH);

        FileWriter writer = new FileWriter(file2);

        StringBuilder sb = new StringBuilder();

        while(scanner.hasNextDouble()){

            double data = scanner.nextDouble();
            int num = (int) Math.round(data);
            sb.append(num + " ");
        }

        writer.write(sb.toString());
        writer.flush();

        reader.close();
        scanner.close();
        writer.close();

    }
}
