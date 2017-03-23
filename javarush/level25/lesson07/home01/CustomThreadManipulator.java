package com.javarush.test.level25.lesson07.home01;

public interface CustomThreadManipulator extends Runnable {
    public void start(String threadName) throws InterruptedException;
    public void stop();
}
