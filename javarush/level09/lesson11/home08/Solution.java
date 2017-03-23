package com.javarush.test.level09.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> list = new ArrayList<>();
        int[] arr1 = new int[5];
        list.add(arr1);
        for (int i = 0, arr1Length = arr1.length; i < arr1Length; i++) {
            int b = (int) (Math.random());
            arr1[i] = b;
        }
        int[] arr2 = new int[2];
        list.add(arr2);
        for (int i = 0, arr1Length = arr2.length; i < arr1Length; i++) {
            int b = (int) (Math.random());
            arr2[i] = b;
        }
        int[] arr3 = new int[4];
        list.add(arr3);
        for (int i = 0, arr1Length = arr3.length; i < arr1Length; i++) {
            int b = (int) (Math.random());
            arr3[i] = b;
        }

        int[] arr4 = new int[7];
        list.add(arr4);
        for (int i = 0, arr1Length = arr4.length; i < arr1Length; i++) {
            int b = (int) (Math.random());
            arr4[i] = b;
        }
        int[] arr5 = new int[0];
        list.add(arr5);
        for (int i = 0, arr1Length = arr5.length; i < arr1Length; i++) {
            int b = (int) (Math.random());
            arr5[i] = b;
        }

        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
