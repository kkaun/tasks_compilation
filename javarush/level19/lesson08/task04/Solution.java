package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {

    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        String[] primer = outputStream.toString().split(" ");

        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (String a: primer)
        {
            try{
                nums.add(Integer.parseInt(a));
            } catch (Exception e)
            {

            }
        }
        String operation = primer[1];

        int result = 0;

        for (String a: primer)
        {
            if (a.equals("+"))
            {
                result = (nums.get(0) + nums.get(1));
            } else if (a.equals("*"))
            {
                result = (nums.get(0) * nums.get(1));
            } else if (a.equals("-"))
            {
                result = (nums.get(0) - nums.get(1));
            }
        }
        String resString = nums.get(0) + " " + operation + " " + nums.get(1) + " = " + result;
        //Возвращаем все как было
        System.setOut(consoleStream);
        //выводим ее в консоль
        System.out.println(resString);
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

