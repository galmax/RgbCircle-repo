package com.example.jarvis.rgbcircle;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Jarvis on 24.04.2016.
 */
public class SimpleCircle {
    protected int x;
    protected int y;
    protected int radius;
    private int color;

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

    public int getColor() {
        return color;
    }

    public void setColor(int color){
        this.color = color;
    }

    public SimpleCircle getCircleArea() {
        return new SimpleCircle(x, y, radius * 3);
    }

    public boolean isIntersect(SimpleCircle circle) {
        return radius + circle.radius >= Math.sqrt(Math.pow(x - circle.x, 2) + Math.pow(y - circle.y, 2));
    }
}
