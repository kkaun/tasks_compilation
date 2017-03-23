package com.javarush.test.LectureExamples;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Кира on 14.10.2016.
 */
public class CopyBytesFromFileToFile {

    public static void main(String[] args) throws Exception
    {
        //Создаем поток-чтения-байт-из-файла
        FileInputStream inputStream = new FileInputStream("d:/xampp/catalina_service.bat");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("d:/result.txt");

        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            outputStream.write(data); // и записать его во второй поток
        }

        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();
    }
}
