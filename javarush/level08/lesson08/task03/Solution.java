package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap() {

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("aaa", "aaa");
        map.put("2", "b");
        map.put("3", "c");
        map.put("aaa", "4");
        map.put("e", "e");
        map.put("6", "f");
        map.put("7", "6");
        map.put("b", "b");
        map.put("aaa", "aaa");
        map.put("aaa", "aaa");
        return map;
    }
    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;
        Iterator<Map.Entry<String, String>>iterator = map.entrySet().iterator();
        while(iterator.hasNext())
        {
            if (name.equals(iterator.next().getValue()))
                count++;
        }
        return count;
    }
    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int count2 = 0;
        Iterator<Map.Entry<String, String>>iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            if (familiya.equals(iterator.next().getKey()))
                count2++;
        }

        return count2;
    }
    public static void main(String[] args)
    {
        System.out.println(getCountTheSameFirstName(createMap(), "aaa"));
        System.out.println(getCountTheSameLastName(createMap(), "aaa"));
    }
}