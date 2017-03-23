package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {


    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!(line = reader.readLine()).equals("exit"))
        {
            ReadThread thread = new ReadThread(line);
            thread.start();
            thread.join();

        }
        reader.close();

    }

    public static class ReadThread extends Thread {

        String fileName;

        public ReadThread(String fileName) {

            this.fileName = fileName;
        }

        public void run() {

            try {

                TreeMap<Integer, Integer> map = new TreeMap();

                FileInputStream inputStream = new FileInputStream(fileName);

                while (inputStream.available() > 0)
                {
                    int a = inputStream.read();

                    if (map.get(a) == null)
                        map.put(a, 1);

                    else
                        map.put(a, map.get(a) + 1);
                }

                int maxValue = -1;
                int symbol = -1;

                for (Map.Entry<Integer, Integer> pair : map.entrySet())
                {
                    int key = pair.getKey();
                    int value = pair.getValue();
                    if (maxValue < value)
                    {
                        maxValue = value;
                        symbol = key;
                    }
                }

                inputStream.close();

                        resultMap.put(fileName, symbol);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
