package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        String file1=buff.readLine();
        String file2=buff.readLine();
        String file3=buff.readLine();

        buff.close();

        FileReader fr1 = new FileReader(file2);
        FileReader fr2 = new FileReader(file3);
        FileWriter fw = new FileWriter(file1);

        while(fr1.ready()){
            fw.write(fr1.read());
        }

        while (fr2.ready()){
            fw.write(fr2.read());
        }

        fw.close();
        fr1.close();
        fr2.close();
    }
    }
