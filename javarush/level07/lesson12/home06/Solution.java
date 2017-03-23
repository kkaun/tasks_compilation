package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args)
    {

        ArrayList<Human> list = new ArrayList<Human>();
        Human grandFather1 = new Human("Bob", true, 95, null, null);
        Human grandFather2 = new Human("bab", true, 94, null, null);
        Human grandMother1 = new Human("Bgb", false, 92, null, null);
        Human grandMother2 = new Human("gfd", false, 91, null, null);
        Human father = new Human("Fadaw", true, 43, grandFather1, grandMother1);
        Human mother = new Human("Fadwa", false, 43, grandFather2, grandMother2);
        Human child1 = new Human("Fat", false, 33, father, mother);
        Human child2 = new Human("Fadawdaw", true, 23, father, mother);
        Human child3 = new Human("Ghdh", true, 13, father, mother);

        Collections.addAll(list, grandFather1, grandFather2, grandMother1, grandMother2, father, mother, child1, child2, child3);
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;


        }

    }

}
