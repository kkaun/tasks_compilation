package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {

        ArrayList<String> list2 = new ArrayList<String>();

        list2.add("efseffesfe");

        ArrayList<String>[] list1 = new ArrayList[1];

        list1[0] = list2;

        return list1;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (int i = 0, arrayOfStringListLength = arrayOfStringList.length; i < arrayOfStringListLength; i++) {
            ArrayList<String> list = arrayOfStringList[i];
            for (int i1 = 0, listSize = list.size(); i1 < listSize; i1++) {
                String s = list.get(i1);
                System.out.println(s);
            }
        }
    }
}