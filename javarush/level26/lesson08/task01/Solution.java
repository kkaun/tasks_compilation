package com.javarush.test.level26.lesson08.task01;

import java.util.concurrent.atomic.AtomicReference;

/* Вежливость - это искусственно созданное хорошее настроение.
В классе Solution создайте public static класс IntegerHolder.
IntegerHolder должен быть для типа int, быть нитебезопасным и изменяемым.
В этом классе должны быть два public метода get и set
*/
public class Solution {

    static IntegerHolder instance = new IntegerHolder();
    static {
        instance.set(0);
    }
    public static void main(String[] args) throws InterruptedException
    {
        Thread t1 = new TestThread();
        Thread t2 = new TestThread();
        t1.start();
        t2.start();
        while (!(t1.getState() == Thread.State.TERMINATED && t2.getState() == Thread.State.TERMINATED));
        System.out.println(instance.get());
    }
    public static class TestThread extends Thread
    {
        @Override
        public void run()
        {
            for (int i = 0; i < 1000000; i++)
            {
                synchronized (instance) {
                    instance.set(instance.get() + 1);
                }
            }
        }
    }
    public static class IntegerHolder
    {
        private final AtomicReference<Integer> hi = new AtomicReference<>();

        public int get() {
            synchronized (this) {
                return hi.get();
            }
        }
        public synchronized void set(int i) {
            synchronized (this) {
                hi.set(i);
            }
        }
    }
}
