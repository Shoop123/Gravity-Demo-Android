package com.custom.gravitydemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class GameLoop implements Runnable {

    SurfaceHolder holder;

    long elapsedTime = 0;

    GravityCircle gc = new GravityCircle();

    public GameLoop(SurfaceHolder holder) {

        this.holder = holder;

    }

    @Override
    public void run() {

        final int FPS = 1000 / 60;

        long pastTime = 0;

        while(true) {

            long currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - pastTime;

            if(elapsedTime >= FPS) {

                //TODO add render, processInput, and Update methods

                render();
                update();
                processInput();

                pastTime = currentTime;

            }

        }

    }

    private void render() {

        Canvas canvas = null;
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(100f);

        try {

            canvas = holder.lockCanvas();
            canvas.drawColor(Color.WHITE);
            canvas.drawText(String.valueOf(1000 / elapsedTime), 0, 100, paint);

            gc.render(canvas);

        } catch (NullPointerException npe) {
            npe.printStackTrace();
        } finally {
            if(canvas != null)
                holder.unlockCanvasAndPost(canvas);
        }

    }

    private void update() {
        gc.update();
    }

    private void processInput() {
        gc.processInput();
    }

}
