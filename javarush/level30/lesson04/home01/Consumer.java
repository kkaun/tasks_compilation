package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Кира on 15.11.2016.
 */
public class Consumer implements Runnable {

    /**
     * 5. Реализация метода run для Consumer:
     5.1. Усыпить трэд на 0.5 секунды
     5.2. В бесконечном цикле заберите элемент из очереди методом take и выведите в консоль "Processing item.toString()".
     */

    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            try {

                Thread.sleep(500);

                while (true){
                    ShareItem item = queue.take();
                    System.out.println("Processing " + item.toString());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
