package com.javarush.test.level29.lesson15.big01.human;

/**
 * Created by Кира on 30.11.2016.
 */
public abstract class UniversityPerson extends Human {

    private University university;
    private String name;
    private int age;

    public UniversityPerson(String name, int age){
        super(name, age);
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public University getUniversity() {
        return university;
    }
    public void setUniversity(University university) {
        this.university = university;
    }

}
