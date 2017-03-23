package com.javarush.test.level38.lesson04.task02;

/* Непроверяемые исключения (unchecked exception)
Напиши реализацию метода methodThrowsClassCastException(). Он должен
всегда кидать непроверяемое исключение ClassCastException.

Напиши реализацию метода methodThrowsNullPointerException(). Он должен
всегда кидать непроверяемое исключение NullPointerException.

Кинуть исключение (throw) явно нельзя.
*/

import java.util.List;

public class VeryComplexClass {

    public void methodThrowsClassCastException() {
        //напишите тут ваш код
        Object i = Integer.valueOf(42);
        String s = (String)i;

    }

    public void methodThrowsNullPointerException() {
        //напишите тут ваш код
        String s = null;

        List<String> list = null;

        list.add(s);
    }
}
