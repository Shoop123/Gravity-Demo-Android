package com.custom.gravitydemo;

import android.view.MotionEvent;
import android.view.View;

public class Input implements View.OnTouchListener {

    public static boolean touch = false;

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN)
            touch = true;
        if(event.getAction() == MotionEvent.ACTION_UP)
            touch = false;

        return true;
    }

}
