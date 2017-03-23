package com.javarush.test.level22.lesson13.task01;

import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {

    public static void main(String[] args) {
        for (String s: getTokens("level22.lesson13.task01", ".")){
            System.out.print(s);
        }
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        String[] result = new String[st.countTokens()];
        int count = 0;
        while(st.hasMoreTokens()){
            result[count] = st.nextToken();
            count++;
        }
        return result;
    }
}
