package com.example.jarvis.rgbcircle;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by Jarvis on 24.04.2016.
 */
public class GameManager {
    public static final int MAX_CIRCLES = 10;
    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> circles;
    private CanvasCircle canvasCircle;
    private static int width;
    private static int height;

    public GameManager(CanvasCircle canvasCircle, int w, int h) {
        this.canvasCircle = canvasCircle;
        width = w;
        height = h;
        initMainCircle();
        initEnemyCircles();
    }

    private void initEnemyCircles() {
        circles = new ArrayList<EnemyCircle>();
        for (int i = 0; i < MAX_CIRCLES; i++) {
            EnemyCircle enemyCircle;
            enemyCircle = EnemyCircle.getRandomCircle();
            circles.add(enemyCircle);
        }
        calculateAndSetEnemyColor();
    }

    private void calculateAndSetEnemyColor() {
        for (EnemyCircle circle : circles) {
            circle.setEnemyOrFoodColorDependsOn(mainCircle);
        }
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
        for (EnemyCircle enemyCircle: circles) {
            canvasCircle.drawCircle(enemyCircle);
        }
    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
    }
}
