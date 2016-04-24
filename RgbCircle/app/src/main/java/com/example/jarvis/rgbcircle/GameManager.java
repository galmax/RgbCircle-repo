package com.example.jarvis.rgbcircle;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Jarvis on 24.04.2016.
 */
public class GameManager {
    private MainCircle mainCircle;
    private CanvasCircle canvasCircle;
    private static int width;
    private static int height;

    public GameManager(CanvasCircle canvasCircle, int w, int h) {
        this.canvasCircle = canvasCircle;
        width = w;
        height = h;
        initMainCircle();
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    public void onDraw() {
        canvasCircle.drawCircle(mainCircle);
    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
    }
}
