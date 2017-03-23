package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Кира on 06.12.2016.
 */
public class Home extends GameObject {
    private final int x;
    private final int y;

    public Home(int x, int y) {
        super(x, y);
        this.x = 2;
        this.y = 2;
    }

    @Override
    public void draw(Graphics graphics) {

        graphics.setColor(Color.RED);

        int leftUpperCornerX = getX();
        int leftUpperCornerY = getY();


        graphics.drawOval(leftUpperCornerX, leftUpperCornerY, getWidth()/4, getHeight()/4);
        graphics.fillOval(leftUpperCornerX, leftUpperCornerY, getWidth()/4, getHeight()/4);

    }



}
