package com.javarush.test.level25.lesson02.task02;

import java.util.ArrayList;
import java.util.List;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {

    public static void main(String[] args) {

        Car car = new Car();

        car.loadWheelNamesFromDB();

    }

    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }



    public static class Car {

        protected List<Wheel> wheels;

        public Car() {
            //init wheels here

            Wheel frontRight = Wheel.FRONT_RIGHT;
            Wheel backRight = Wheel.BACK_RIGHT;
            Wheel frontLeft = Wheel.FRONT_LEFT;
            Wheel backLeft = Wheel.BACK_LEFT;

            wheels = new ArrayList<Wheel>();

            if(loadWheelNamesFromDB().length != 4){
                System.out.println("Car is broken!");
            }

            for(int i = 0; i < loadWheelNamesFromDB().length; i ++) {
                if(loadWheelNamesFromDB()[i].equals(frontLeft.toString())||loadWheelNamesFromDB()[i].equals(frontRight.toString())||
                        loadWheelNamesFromDB()[i].equals(backLeft.toString())||loadWheelNamesFromDB()[i].equals(backRight.toString())) {
                    wheels.add(Wheel.valueOf(loadWheelNamesFromDB()[i]));
                }
                else {
                    System.out.println("Car is really broken!");
                    break;
                }
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
}
