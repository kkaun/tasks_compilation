package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try{
            float i = 2/0;
        }
        catch(Exception e1){
            exceptions.add(e1);
        }
        try{
            int i = 2/0;
        }
        catch(Exception e1){
            exceptions.add(e1);
        }
        try{
            double i = 2/0;
        }
        catch(Exception e1){
            exceptions.add(e1);
        }
        try{
            byte i = (byte) (2/0);
        }
        catch(Exception e1){
            exceptions.add(e1);
        }
        try{
            char i = (char) (2/0);
        }
        catch(Exception e1){
            exceptions.add(e1);
        }
        try{
            long i = 2/0;
        }
        catch(Exception e1){
            exceptions.add(e1);
        }
        try{
            String i = String.valueOf(2/0);
        }
        catch(Exception e1){
            exceptions.add(e1);
        }
        try{
            float i = 22/0;
        }
        catch(Exception e1){
            exceptions.add(e1);
        }
        try{
            float i = 26/0;
        }
        catch(Exception e1){
            exceptions.add(e1);
        }

    }
}
