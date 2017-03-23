package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.math.BigDecimal;


public class Solution {
    public static void main(String[] args) throws IOException {

            File file = new File(args[0]);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);

            int countAll = dis.available();
            int countSpace = 0;
            while (dis.available() > 0) {
                String s = "";
                String[] data = s.split("");
                for (String x : data) {
                    if (x.equals(" "))
                        countSpace++;
                }
            }
            double dCountSpace = (double) countSpace;
            double dCountAll = (double) countAll;
            double c = (dCountSpace / dCountAll) * 100;

            double f = round(c, 2, BigDecimal.ROUND_HALF_UP);
            System.out.print(f);

            fis.close();
            bis.close();
            dis.close();
        }

        public static double round (double unrounded, int precision, int roundingMode)
        {
            BigDecimal bd = new BigDecimal(unrounded);
            BigDecimal rounded = bd.setScale(precision, roundingMode);
            return rounded.doubleValue();
        }

}

