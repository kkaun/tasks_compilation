package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fread = new FileReader(reader.readLine());
        FileWriter fwrite = new FileWriter(reader.readLine());
        reader.close();

        int count = 0;

        while (fread.ready()) {

        count++;

            int data = fread.read();

            if(count != 0){
                if(count % 2 == 0){
                    fwrite.write(data);                             //ЗАПИСЫВЕМ ПО ОДНОМУ(!!!!!!) БАЙТУ!!!!
                }
            }

        }

        fread.close();
        fwrite.close();
    }
}
