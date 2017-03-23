package com.javarush.test.level25.lesson11.task02;

/* Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
Обеспечьте переуступку кванта времени (переход хода для текущей нити) для последовательных выводов текста в консоль
*/
public class Solution {
    public static void main(String[] args) {
        Thread t1 = new Thread(new YieldRunnable(4));
        Thread t2 = new Thread(new YieldRunnable(3));
        Thread t3 = new Thread(new YieldRunnable(2));
        Thread t4 = new Thread(new YieldRunnable(1));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }
}
