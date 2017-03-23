package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {

    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }


    static {
        labels.put(4.6758, "daw645");
    }

    static {
        labels.put(4.6453, "dagfw");
    }

    static {
        labels.put(4.643242, "dawtgr");
    }

    static {
        labels.put(4.64324, "dagtrw");
    }

    static {
        labels.put(4.6352, "dagtrw");
    }


}
