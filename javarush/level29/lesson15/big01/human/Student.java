package com.javarush.test.level29.lesson15.big01.human;

import java.util.Date;

public class Student extends UniversityPerson{

    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }
    public void live() {
        learn();
    }
    public void learn() {
    }


    public void incAverageGrade(double delta){

        setAverageGrade(this.getAverageGrade() + delta);
    }


    public void setAverageGrade(double averageGrade)
    {
        this.averageGrade = averageGrade;
    }
    public void setCourse(int course)
    {
        this.course = course;
    }


    public void setBeginningOfSession(Date beginningOfSession) {
        this.beginningOfSession = beginningOfSession;
    }
    public void setEndOfSession(Date endOfSession) {
        this.endOfSession = endOfSession;
    }


    public double getAverageGrade() {
        return averageGrade;
    }

    public int getCourse() {
        return course;
    }


    @Override
    public String getPosition() {
        return "Студент";
    }
}
