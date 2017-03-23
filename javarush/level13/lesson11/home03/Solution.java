package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn = reader.readLine();
        //--------------------------------------
        InputStream text = new FileInputStream(fn);     //  читаем файл
        while (text.available() > 0)                    //  читаем пока не закончатся символы
        {
            System.out.print((char) text.read());       // выводим прочитанный символ
        }
        //--------------------------------
        reader.close();                                 // закрываем поток чтения с клавиатуры
        text.close();                                   // закрываем поток чтения из файла
    }
}

