package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        InputStream inputStream = new FileInputStream(file1);

        byte[] buff1 = new byte[inputStream.available()];

        inputStream.read(buff1);
        inputStream.close();

        InputStream inputStream2 = new FileInputStream(file2);

        byte[] buff2 = new byte[inputStream2.available()];

        inputStream2.read(buff2);
        inputStream2.close();
        OutputStream outputStream = new FileOutputStream(file1);
        outputStream.write(buff2);
        outputStream.write(buff1);
        outputStream.close();
    }
}
