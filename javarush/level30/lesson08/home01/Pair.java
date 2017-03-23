package com.javarush.test.level30.lesson08.home01;

public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x=%d, y=%d", x, y);
    }

    public void swap() {

        x ^= y; // стало 2
        System.out.println(x);
        y ^= x; // стало 5
        System.out.println(y);
        x ^= y; //стало 7
        System.out.println(x);
    }
}
