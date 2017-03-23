package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("Jun 1 1980"));
        map.put("Stallon", new Date("Jul 1 1980"));
        map.put("Stallodwa", new Date("Aug 1 1980"));
        map.put("Stallodaw", new Date("Jan 1 1980"));
        map.put("Stalloa", new Date("Sep 1 1980"));
        map.put("Stallodawd", new Date("Sep 1 1980"));
        map.put("Stalldawo", new Date("Sep 1 1980"));
        map.put("Stallodawdaw", new Date("Sep 1 1980"));
        map.put("Stalloaa", new Date("Sep 1 1980"));
        map.put("Stallovv", new Date("Sep 1 1980"));


        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {


        Iterator<Map.Entry<String, Date>> summer = map.entrySet().iterator();
        while (summer.hasNext()) {
            Map.Entry<String, Date> pair = summer.next();
            if (pair.getValue().getMonth() == 5 || pair.getValue().getMonth() == 6 || pair.getValue().getMonth() == 7) {
                summer.remove();
            }

        }
    }
    public static void main(String[] args){

        removeAllSummerPeople(createMap());
        System.out.println(createMap());


    }

}

