package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String temp = reader.readLine();                           //создаем строку для чтения
        String allArguments = temp.substring(temp.indexOf("?") + 1);     //создаем строку для всех параметров(идут после ?
        String[] parsedstr = allArguments.split("&");                   //и разделяются &) массив "убирает" & и принимает все оставшееся себе
        for (int i = 0; i < parsedstr.length; i++) {                  //шерстим циклом по ссылке без знака &
            String currentArg = parsedstr[i];                          //присаиваем новой строке все параметры, которые находим
            String[] currentArrClean = parsedstr[i].split("=");            //попутно пропускаем "="
            if (i == parsedstr.length - 1) {                                 //если в итоге параметр 1 - печатаем его
                System.out.print(currentArrClean[0]);
            } else {                                                       //если 2 и более - печатаем их черех пробел
                System.out.print(currentArrClean[0] + " ");
            }
        }

        System.out.println();                                       //для перехода на сл строку(разделения методов)

        for (int i = 0; i < parsedstr.length; i++) {                   //еще раз проходимся циклом по ссылке для определение obj
            String currentArg = parsedstr[i];                            //по аналогии с первым циклом
            String[] currentArrClean = parsedstr[i].split("=");
            try {                                                             //а вот здесь решение затянулось часа на 2, так и не
                if (currentArrClean[0].equals("obj")) {
                    if (currentArrClean[1].equals(Double.parseDouble(currentArg))) {   //дошло, что делать с отловленными строками со
                        alert(Double.parseDouble(currentArrClean[1]));
                    }                                                                   //сторонними символами
                    if (!currentArrClean[1].equals(Integer.parseInt(currentArg))) {
                        alert(currentArrClean[1]);
                    }
                }
                if (!currentArrClean[0].equals("obj")) {
                    break;
                }
            }

            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
