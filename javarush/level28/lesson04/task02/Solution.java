package com.javarush.test.level28.lesson04.task02;

import java.util.concurrent.ThreadLocalRandom;

/* ThreadLocalRandom
Класс Solution будет использоваться трэдами.
Реализуйте логику всех методов, используйте класс ThreadLocalRandom.
getRandomIntegerBetweenNumbers должен возвращать случайный int между from и to
getRandomDouble должен возвращать случайный double
getRandomLongBetween0AndN должен возвращать случайный long между 0 и n
*/
public class Solution implements Runnable {

    public static int getRandomIntegerBetweenNumbers(int from, int to) {

        int newRandom = ThreadLocalRandom.current().nextInt(from, to);

        return newRandom;
    }

    public static double getRandomDouble() {

        double newRandom = ThreadLocalRandom.current().nextDouble(Math.random());

        return newRandom;
    }

    public static long getRandomLongBetween0AndN(long n) {

        long newRandom = ThreadLocalRandom.current().nextLong(n);

        return newRandom;
    }

    @Override
    public void run() {

    }
}
