package com.javarush.test.level34.lesson15.big01.controller;

import com.javarush.test.level34.lesson15.big01.model.Direction;

/**
 * Created by Кира on 06.12.2016.
 */
public interface EventListener {

    public void move(Direction direction);

    public void restart();

    public void startNextLevel();

    public void levelCompleted(int level);

}
