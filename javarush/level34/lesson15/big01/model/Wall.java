package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Кира on 06.12.2016.
 */
public class Wall extends CollisionObject {

    private final int x;
    private final int y;

    public Wall(int x, int y) {
        super(x, y);
        this.x = 2;
        this.y = 2;
    }

    @Override
    public void draw(Graphics graphics) {

        graphics.setColor(Color.DARK_GRAY);

        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;


        graphics.drawRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
        graphics.fillRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
    }

}
