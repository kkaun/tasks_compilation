package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Кира on 07.11.2016.
 */
public class CurrencyManipulator {

    private String currencyCode;

    private Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();

    public CurrencyManipulator(String currencyName) {
        this.currencyCode = currencyName;
    }

    public void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination,count);
    }

    public int getTotalAmount(){
        int result = 0;
        for(Map.Entry<Integer,Integer> pair : denominations.entrySet())
            result = result + (pair.getKey() * pair.getValue());

        return result;
    }

    public boolean hasMoney(){
        return denominations.size() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException, ConcurrentModificationException
    {
        Map<Integer, Integer> resultMap = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, Integer> copymap = new TreeMap<>(Collections.reverseOrder());

        copymap.putAll(denominations);

        for (Map.Entry<Integer, Integer> entry : copymap.entrySet()){
            int counter = 0;                              //счетчик
            while (entry.getValue() > 0){                 //проходимся по значения мапы
                if(entry.getKey() <= expectedAmount)
                {
                    expectedAmount -= entry.getKey();
                    counter++;
                }else{

                    break;
                }
            }

            if(counter > 0){
                resultMap.put(entry.getKey(), counter);
                entry.setValue(entry.getValue() - counter);
            }
        }

        if(expectedAmount != 0)
        {
            throw new NotEnoughMoneyException();
        }
        else{
            denominations.clear();
            denominations.putAll(copymap);
        }

        return resultMap;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}
