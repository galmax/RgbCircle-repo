package com.example.jarvis.rgbcircle;

/**
 * Created by Jarvis on 24.04.2016.
 */
public class SimpleCircle {
    protected int x;
    protected int y;
    protected int radius;

    public SimpleCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public int getRadius() {
        return radius;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
