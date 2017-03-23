package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Кира on 17.12.2016.
 */
public class Restaurant {

    private final static LinkedBlockingQueue<Order> QUEUE = new LinkedBlockingQueue<>();

    private final static int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) throws InterruptedException {

        Locale.setDefault(Locale.ENGLISH);
        Cook cook1 = new Cook("Amigo");
        Cook cook2 = new Cook("Ogima");

        cook1.setQueue(QUEUE);
        cook2.setQueue(QUEUE);

        Thread cook1Thread = new Thread(cook1);
        Thread cook2Thread = new Thread(cook2);

        cook1Thread.start();
        cook2Thread.start();

        Waitor waitor = new Waitor();

        cook1.addObserver(waitor);
        cook2.addObserver(waitor);

        List<Tablet> tablets = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(QUEUE);
            tablets.add(tablet);
        }

        Thread randomOrderThread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        randomOrderThread.start();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
        }

        randomOrderThread.interrupt();

        cook1Thread.interrupt();
        cook2Thread.interrupt();

        try {
            cook1Thread.join();
            cook2Thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
