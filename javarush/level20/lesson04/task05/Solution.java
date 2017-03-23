package com.javarush.test.level20.lesson04.task05;

import java.io.*;

/* Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной
*/
public class Solution {

    public static void main(java.lang.String[] args) throws Exception{

        Object object = new Object();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("d:/3.txt"));
        out.writeObject(object);

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("d:/3.txt"));
        java.lang.Object object1 = oin.readObject();

        Object objectNew = (Object) object1;


        System.out.println(objectNew);
    }


    public Solution() throws IOException {
    }

    public static class Object implements Serializable {
        public String string1;
        public String string2;
    }

    public static int countStrings;

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
