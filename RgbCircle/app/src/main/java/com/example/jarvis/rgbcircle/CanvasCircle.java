package com.example.jarvis.rgbcircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.Dictionary;

/**
 * Created by Jarvis on 24.04.2016.
 */
public class CanvasCircle extends View implements ICanvasView {
    private static int width;
    private static int height;

    private Canvas canvas;
    private GameManager gameManager;
    private Paint paint;

    public CanvasCircle(Context context, AttributeSet attrs) {
        super(context, attrs);

        initWidthAndHeight(context);
        initPaint();
        gameManager = new GameManager(this, width, height);

    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initWidthAndHeight(Context context) {
        WindowManager windowManager =
                (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        width = point.x;
        height = point.y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        gameManager.onDraw();
    }

    @Override
    public void drawCircle(SimpleCircle circle) {
        canvas.drawCircle(circle.getX(), circle.getY(), circle.getRadius(), paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        if(event.getAction() == MotionEvent.ACTION_MOVE){
            gameManager.onTouchEvent(x, y);
        }
        invalidate();
        return true;
    }
}
