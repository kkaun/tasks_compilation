package com.javarush.test.level37.lesson04.big01.female;

import com.javarush.test.level37.lesson04.big01.AbstractFactory;
import com.javarush.test.level37.lesson04.big01.Human;

/**
 * Created by Кира on 14.12.2016.
 */
public class FemaleFactory implements AbstractFactory {

    public Human getPerson(int age){

        if(age >= 0 && age <= KidGirl.MAX_AGE){
            Human kb = new KidGirl();
            return kb;
        }
        if(age > KidGirl.MAX_AGE && age <= TeenGirl.MAX_AGE){
            Human tb = new TeenGirl();
            return tb;
        }
        else {
            Human man = new Woman();
            return man;
        }
    }
}
