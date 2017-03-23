package com.javarush.test.level23.lesson13.big01;

import java.util.Objects;

public class SnakeSection
{
    private int x;
    private int y;

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        SnakeSection object = (SnakeSection) obj;

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        return Objects.equals(x, object.x) && Objects.equals(y, object.y);
    }

    public SnakeSection(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}
