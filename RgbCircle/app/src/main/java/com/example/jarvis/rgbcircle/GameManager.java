package com.example.jarvis.rgbcircle;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Jarvis on 24.04.2016.
 */
public class GameManager {
    private MainCircle mainCircle;
    private Paint paint;
    private CanvasCircle canvasCircle;
    private static int width;
    private static int height;

    public GameManager(CanvasCircle canvasCircle, int w, int h) {
        width = w;
        height = h;
        this.canvasCircle = canvasCircle;
        initMainCircle();
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
    }
}
