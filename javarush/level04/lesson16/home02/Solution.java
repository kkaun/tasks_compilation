package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String a = reader.readLine();
        String b = reader.readLine();
        String c = reader.readLine();
        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        int c1 = Integer.parseInt(c);

        if(a1 > b1 && b1 > c1){
            System.out.println(b1);
        }
        else if(b1 > a1 && a1> c1){
            System.out.println(a1);
        }
        else if(c1 > a1 && a1 > b1){
            System.out.println(a1);
        }
        else if(b1 > c1 && c1 > a1){
            System.out.println(c1);
        }
        else if(a1 > c1 && c1 > b1){
            System.out.println(c1);
        }
        else if(c1 > b1 && b1 > c1){
            System.out.println(b1);
        }
    }
}
