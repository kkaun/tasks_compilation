package com.javarush.test.level32.lesson04.task01;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;

/* Пишем стек-трейс
Реализуйте логику метода getStackTrace, который в виде одной строки должен возвращать весь стек-трейс переданного исключения.
Используйте подходящий метод класса Throwable, который поможет записать стек-трейс в StringWriter.
*/
public class Solution {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {

        StringWriter sw = new StringWriter();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        throwable.printStackTrace(ps);

        sw.write(baos.toString());

        return String.valueOf(sw);
    }
}
