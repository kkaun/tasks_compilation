package com.javarush.test.level37.lesson04.big01.male;

import com.javarush.test.level37.lesson04.big01.AbstractFactory;
import com.javarush.test.level37.lesson04.big01.Human;

/**
 * Created by Кира on 14.12.2016.
 */
public class MaleFactory implements AbstractFactory{

    public Human getPerson(int age){

        if(age >= 0 && age <= KidBoy.MAX_AGE){
            Human kb = new KidBoy();
            return kb;
        }
        if(age > KidBoy.MAX_AGE && age <= TeenBoy.MAX_AGE){
            Human tb = new TeenBoy();
            return tb;
        }
        else {
            Human man = new Man();
            return man;
        }
    }
}
