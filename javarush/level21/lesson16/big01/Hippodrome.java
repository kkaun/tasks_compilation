package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Кира on 26.10.2016.
 */
public class Hippodrome {

    public static Hippodrome game;

    ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {

        game = new Hippodrome();

        Horse gnedaya = new Horse("Gnedaya", 3, 0);
        Horse rizhyk = new Horse("Rizhyk", 3, 0);
        Horse manya = new Horse("Manya", 3, 0);

        game.getHorses().add(gnedaya);
        game.getHorses().add(rizhyk);
        game.getHorses().add(manya);

        game.run();



    }

    public void run() throws InterruptedException {

        for(int i = 1; i <= 100; i ++){
            print();
            move();
            Thread.sleep(200);
        }

        printWinner();

    }

    public void move(){

        for (Horse h : horses){
            h.move();
        }

    }

    public void print(){

        for (Horse h : horses){
            h.print();

        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){

        double max = 0;

        for(int i = 0; i < horses.size(); i++){
            if(max < horses.get(i).distance){
                max = horses.get(i).distance;
            }
        }

        for(Horse h : horses) {
            if (h.distance == max) {
                return h;
            }
        }

        return null;

    }

    public void printWinner(){

        System.out.println("Winner is " + getWinner().getName() + "!");

    }

}
