package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws Exception {


        if(args.length > 0)
        {
            String ifile = args[1];
            String ofile = args[2];
            if(args[0].equals("-e"))
                encrypt(ifile, ofile);
            else if(args[0].equals("-d"))
                decrypt(ifile, ofile);
        }
    }


    public static void encrypt(String filein, String fileout) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(filein);
        FileOutputStream outputStream = new FileOutputStream(fileout);
        while (inputStream.available()>0)
        {
            int read = inputStream.read()-1;
            outputStream.write(read);
        }
        inputStream.close();
        outputStream.close();
    }


    public static void decrypt(String filein, String fileout) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(filein);
        FileOutputStream outputStream = new FileOutputStream(fileout);
        while (inputStream.available()>0)
        {
            int read = inputStream.read()+1;
            outputStream.write(read);
        }
        inputStream.close();
        outputStream.close();
    }
}
