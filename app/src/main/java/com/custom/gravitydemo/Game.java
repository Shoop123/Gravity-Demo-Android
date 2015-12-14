package com.custom.gravitydemo;

import android.view.SurfaceHolder;

public class Game implements SurfaceHolder.Callback {

    SurfaceHolder holder;

    Thread gameThread;

    GameLoop gm;

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        this.holder = holder;

        start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        stop();

    }

    private void start() {

        gm = new GameLoop(holder);
        gameThread = new Thread(gm);
        gameThread.start();

    }

    private void stop() {

        try {
            gameThread.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }
}
