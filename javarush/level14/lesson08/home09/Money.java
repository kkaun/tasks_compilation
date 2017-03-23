package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    public Money(double amount)
    {
        amount = 100;
    }

    private double amount = 100;

    public double getAmount(){
        return amount;
    }


    public abstract String getCurrencyName();
}

