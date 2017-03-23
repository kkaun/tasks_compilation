package com.javarush.test.level20.lesson04.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Как сериализовать?
Сделайте так, чтобы сериализация класса Human была возможной
*/
public class Solution {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human human = new Human();

        File file = new File("d:/1.txt");
        FileOutputStream fos = new FileOutputStream("d:/1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
        objectOutputStream.writeObject(human);
        fos.flush();
        fos.close();
        objectOutputStream.close();

        FileInputStream fis  = new FileInputStream("d:/1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fis);
        Object object = objectInputStream.readObject();
        fis.close();
        objectOutputStream.close();

        Human human1 = (Human) object;

        System.out.println(human1.toString());

    }

    public static class Human implements Serializable {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }
}
