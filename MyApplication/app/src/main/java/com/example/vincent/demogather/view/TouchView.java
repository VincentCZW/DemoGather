package com.example.vincent.demogather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by VincentChen on 2016/10/17.
 */
public class TouchView extends TextView {

    public TouchView(Context context) {
        super(context);
        init();
    }

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TouchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("Vincent", "TouchView  dispatchTouchEvent()");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Vincent", "TouchView 事件：按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("Vincent", "TouchView 事件：移动");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("Vincent", "TouchView 事件：取消");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("Vincent", "TouchView 事件：抬起");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Vincent", "TouchView  onTouchEvent()");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Vincent", "TouchView 事件：按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("Vincent", "TouchView 事件：移动");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("Vincent", "TouchView 事件：取消");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("Vincent", "TouchView 事件：抬起");
                break;
        }
        return true;
//        return super.onTouchEvent(event);
//        return true;
    }
}
