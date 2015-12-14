package com.custom.gravitydemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class GravityCircle {

    private int radius;
    private float x;
    private float y;

    private float speedY;
    private float gravity;
    private float upForce;

    private Paint p;

    public GravityCircle() {

        p = new Paint();
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.FILL);
        p.setAntiAlias(true);
        p.setFlags(Paint.ANTI_ALIAS_FLAG);

        radius = 100;
        gravity = 0.7f;
        upForce = 0;
        speedY = 0;
        x = 540;
        y = radius;

    }

    public void render(Canvas canvas) {

        canvas.drawCircle(x, y, radius, p);

    }

    public void update() {

        if(y <= radius) {
            y = radius;
            speedY = 0;
        }

        if(y >= MainActivity.screenHeight - radius*2) {
            y = MainActivity.screenHeight - radius*2;
            speedY = 0;
        }

        speedY += gravity + upForce;

        y += speedY;

    }

    public void processInput() {

        if(Input.touch) {

            upForce = -2.5f;

        } else upForce = 0;

    }

}
