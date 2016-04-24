package com.example.jarvis.rgbcircle;

/**
 * Created by Jarvis on 24.04.2016.
 */
public class MainCircle {
    public static final int INIT_RADIUS = 50;
    private int x;
    private int y;
    private int radius;

    public MainCircle(int x, int y) {
        this.x = x;
        this.y = y;
        radius = INIT_RADIUS;
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
