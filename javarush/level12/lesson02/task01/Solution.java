package com.javarush.test.level12.lesson02.task01;

/* Я не корова, Я - кит.
Переопределить метод getName в классе Whale(Кит), чтобы программа выдавала:
Я не корова, Я - кит.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Whale whale = new Whale();

        System.out.println(whale.getName());
    }

    public static class Cow
    {
        public String getName()
        {
            return "Я не корова, Я - кит.";
        }
    }

    public static class Whale extends Cow
    {

    }
}
