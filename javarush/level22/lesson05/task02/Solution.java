package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null){
            throw new TooShortStringException();
        }

        if(string.length() < 2){
            throw new TooShortStringException();
        }

        int s = string.indexOf("\t");
        boolean f = !string.substring(s+1, string.length()).contains("\t");

        if(f){
            throw new TooShortStringException();
        }

        String[] arr = string.split("\t");

        String ch = "";

        if(arr.length == 0){
            return ch;
        }

        for(int i = 0; i < 2; i++){
             ch = arr[i];
        }

        return ch;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
