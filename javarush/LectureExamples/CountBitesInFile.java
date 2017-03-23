package com.javarush.test.LectureExamples;

import java.io.FileInputStream;

/**
 * Created by Кира on 14.10.2016.
 */
public class CountBitesInFile {

    public static void main(String[] args) throws Exception
    {
        //создаем объект FileInputStream, привязанный к файлу «c:/data.txt».
        FileInputStream inputStream = new FileInputStream("/d:/xampp/catalina_service.bat");
        long sum = 0;

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read(); //прочитать очередной байт
            sum += data; //добавить его к общей сумме
        }
        inputStream.close(); // закрываем поток

        System.out.println(sum); //выводим сумму на экран.
    }
}
