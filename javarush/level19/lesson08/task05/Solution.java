package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        //Считайте с консоли имя файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        reader.close();

        PrintStream consoleStream = System.out;
        //Ваша ридер-обертка
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);
        //Вызовите готовый метод printSomething(), воспользуйтесь testString
        testString.printSomething();

        String resultLine = outputStream.toString();
        //Верните переменной System.out первоначальный поток
        System.setOut(consoleStream);
        //write into console
        System.out.println(resultLine);
        //write into output file
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

        bufferedWriter.write(resultLine);
        //Закройте поток файла
        bufferedWriter.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

