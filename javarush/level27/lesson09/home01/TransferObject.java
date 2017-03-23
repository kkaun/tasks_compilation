package com.javarush.test.level27.lesson09.home01;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable



    public synchronized int get() {

        while (!isValuePresent) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("INTERRUPTED GET");
            }
        }

        System.out.println("Got: " + value);

        isValuePresent = false;

        notifyAll();

        return value;
    }

    public synchronized void put(int value) {

        while (isValuePresent) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("INTERRUPTED PUT");
            }
        }
        this.value = value;

        System.out.println("Put: " + value);

        isValuePresent = true;

        notifyAll();
    }
}
