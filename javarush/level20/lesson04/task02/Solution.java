package com.javarush.test.level20.lesson04.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Как сериализовать JavaRush?
Сделайте так, чтобы сериализация класса JavaRush была возможной
*/
public class Solution {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        JavaRush javaRush = new JavaRush();

        File file = new File("d:/3.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
        objectOutputStream.writeObject(javaRush);
        fos.flush();
        fos.close();
        objectOutputStream.close();



        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fis);
        Object object = objectInputStream.readObject();
        fis.close();
        objectInputStream.close();

        JavaRush jr1 = (JavaRush) object;

        System.out.println(jr1);

    }



    public static class JavaRush implements Serializable {
        public List<User> users = new ArrayList<>();
    }
}
