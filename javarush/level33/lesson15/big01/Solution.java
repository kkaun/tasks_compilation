package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;
import com.javarush.test.level33.lesson15.big01.tests.FunctionalTest;
import com.javarush.test.level33.lesson15.big01.tests.SpeedTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Кира on 03.12.2016.
 */
public class Solution {

    public static void main(String[] args) {

        FunctionalTest functionalTest = new FunctionalTest();

        functionalTest.testFileStorageStrategy();
        functionalTest.testHashMapStorageStrategy();
        functionalTest.testOurHashMapStorageStrategy();
        functionalTest.testHashBiMapStorageStrategy();
        functionalTest.testOurHashBiMapStorageStrategy();
        functionalTest.testDualHashBidiMapStorageStrategy();

        SpeedTest speedTest = new SpeedTest();

        speedTest.testHashMapStorage();

    }


    public static Set<Long> getIds(Shortener shortener, Set<String> strings){

        Set<Long> gotIds = new HashSet<>();
        try {
            if (!strings.isEmpty()) {
                for (String s : strings) {
                    if (s != null) {
                        gotIds.add(shortener.getId(s));
                    }
                }
            }
        }catch (NullPointerException e){
            ExceptionHandler.log(e);
        }
        return gotIds;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){

        Set<String> gotStrings = new HashSet<>();
        try {

            if (keys != null)
                for (Long l : keys) {
                    if(l != null){
                        gotStrings.add(shortener.getString(l));
                    }
                }
        }catch (NullPointerException e){
            ExceptionHandler.log(e);
        }
        return gotStrings;
    }


    public static void testStrategy(StorageStrategy strategy, long elementsNumber){


        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> strings = new HashSet<>();
        Set<Long> keys = new HashSet<>();

        for(int i = 0; i < elementsNumber; i ++) {
            strings.add(Helper.generateRandomString());
            keys.add((long)i);
        }

        Shortener shortener = new Shortener(strategy);

        long t1 = new Date().getTime();
        Set<Long> receivedIds = getIds(shortener, strings);
        Helper.printMessage(String.valueOf(new Date().getTime() - t1));
        long t2 = new Date().getTime();
        Set<String> receivedStrings = getStrings(shortener, receivedIds);
        Helper.printMessage(String.valueOf(new Date().getTime() - t2));

        if (!strings.containsAll(receivedStrings) || !receivedStrings.containsAll(strings)) {
            Helper.printMessage("Тест не пройден.");
        }else {
            Helper.printMessage("Тест пройден.");
        }

    }


}
