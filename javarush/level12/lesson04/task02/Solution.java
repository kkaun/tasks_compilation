package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {

        Solution s = new Solution();
        s.print(1);
        s.print(12);

    }

    void print(int a){

        System.out.println(a);
    }
    void print(Integer b){

        System.out.println(b);
    }
}
