package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student result = null;
        for(Student s : students){
            if(s.getAverageGrade() == averageGrade){
                result = s;
            }
        }
        return result;
    }
    public Student getStudentWithMaxAverageGrade() {
        //TODO:

        if(!students.isEmpty()){
            Student student = students.get(0);
            for(Student curSt : students){
                if(curSt.getAverageGrade() > student.getAverageGrade()){
                    student = curSt;
                }
            }
            return student;
        }

        return null;
    }

    public Student getStudentWithMinAverageGrade(){

        if(!students.isEmpty()){
            Student student = students.get(0);
            for(Student curSt : students){
                if(curSt.getAverageGrade() < student.getAverageGrade()){
                    student = curSt;
                }
            }
            return student;
        }

        return null;
    }

    public void expel(Student student){

        if(students.contains(student)) {
            students.remove(student);
        }
    }

    public List<Student> getStudents(){
        return students;
    }
    public void setStudents(List<Student> students){
        this.students = students;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
