package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.*;

/**
 * Created by Кира on 21.12.2016.
 */
public class TestOrder extends Order {


    public TestOrder(Tablet tablet) throws IOException

    {
        super(tablet);
    }

    @Override
    protected List<Dish> initDishes()
    {
        List<Dish> dishes = new ArrayList<>();

        int dishesCount = (int) (Math.random()*3) + 1;

        for (int i = 1; i <= dishesCount; i++)
        {
            int dishIndex = (int) (Math.random() * Dish.values().length);
            for (Dish dish : Dish.values())
            {
                if(dish.ordinal() == dishIndex)
                {
                    dishes.add(dish);
                    break;
                }
            }
        }

        return dishes;
    }
}
