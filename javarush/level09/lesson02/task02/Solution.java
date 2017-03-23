package com.javarush.test.level09.lesson02.task02;

/* И снова StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static String method1()
    {
        method2();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[2].getMethodName();

    }

    public static String method2()
    {
        method3();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[2].getMethodName();

    }

    public static String method3()
    {
        method4();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[2].getMethodName();

    }

    public static String method4()
    {
        method5();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[2].getMethodName();

    }

    public static String method5()
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[2].getMethodName();

    }
}

//Виталий, вероятно потому, что в стеке нет такого уровня. Смотрите: [0] - это сам стек [1] - это текущий метод
// [2] - это метод, на уровень ниже - то есть тот, который вызвал текущий [3]- соответственно метод, который вызвал метод, который вызвал текущий
// метод... и так далее, пока не достигнет дна стека... То есть отрицательный вариант не возможен...
