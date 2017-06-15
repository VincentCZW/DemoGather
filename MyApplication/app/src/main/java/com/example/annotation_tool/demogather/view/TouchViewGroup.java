package com.example.annotation_tool.demogather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by VincentChen on 2016/10/17.
 */
public class TouchViewGroup extends RelativeLayout {

    public TouchViewGroup(Context context) {
        super(context);
    }

    public TouchViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public TouchViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//
//    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("Vincent", "TouchViewGroup  dispatchTouchEvent()");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Vincent", "TouchViewGroup 事件：按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("Vincent", "TouchViewGroup 事件：移动");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("Vincent", "TouchViewGroup 事件：取消");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("Vincent", "TouchViewGroup 事件：抬起");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Vincent", "TouchViewGroup onTouchEvent()");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Vincent", "TouchViewGroup 事件：按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("Vincent", "TouchViewGroup 事件：移动");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("Vincent", "TouchViewGroup 事件：取消");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("Vincent", "TouchViewGroup 事件：抬起");
                break;
        }
        return super.onTouchEvent(event);
//        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("Vincent", "TouchViewGroup onInterceptTouchEvent()");
//        return true;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            default:
                return false;
        }
//        return false;
    }
}
