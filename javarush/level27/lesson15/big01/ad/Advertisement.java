package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Кира on 18.12.2016.
 */
public class Advertisement {

    private long amountPerOneDisplaying;

    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private Object amountPerSecond;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.duration = duration;
        this.hits = hits;
        this.initialAmount = initialAmount;
        this.name = name;


        this.amountPerOneDisplaying = initialAmount/hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }


    public void revalidate()throws UnsupportedOperationException {
        if (hits <= 0) throw new UnsupportedOperationException();
        hits--;

        if (hits == 1)
            amountPerOneDisplaying += initialAmount % amountPerOneDisplaying;

    }

    public int getHits() {
        return hits;
    }

    public double getAmountPerSecond() {
        return (double)amountPerOneDisplaying / duration;
    }
}
