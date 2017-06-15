package com.example.annotation_tool.demogather.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.annotation_tool.demogather.R;
import com.example.annotation_tool.demogather.view.TouchView;
import com.example.annotation_tool.demogather.view.TouchViewGroup;

/**
 * Created by VincentChen on 2016/10/17.
 */
public class TouchEventTestActivity extends Activity {

    private TouchViewGroup touchViewGroup;

    private TouchView touchView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_touch_event_test_layout);
        initViews();
        bindListener();
    }

    private void initViews() {
        touchViewGroup = (TouchViewGroup) findViewById(R.id.view_group);
        touchView = (TouchView) findViewById(R.id.view);
    }

    private void bindListener() {
        touchViewGroup.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("Vincent", "touchViewGroup onTouch()");
                return false;
            }
        });

        touchViewGroup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("Vincent", "touchViewGroup onClick()");
            }
        });

        touchView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("Vincent", "TouchView onTouch()");
                return false;
            }
        });

        touchView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("Vincent", "TouchView onClick");
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("Vincent", "TouchEventTestActivity  dispathchTouchEvent()");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Vincent", "TouchEventTestActivity 事件：按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("Vincent", "TouchEventTestActivity 事件：移动");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("Vincent", "TouchEventTestActivity 事件：取消");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("Vincent", "TouchEventTestActivity 事件：抬起");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Vincent", "TouchEventTestActivity  onTouchEvent()");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Vincent", "TouchEventTestActivity 事件：按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("Vincent", "TouchEventTestActivity 事件：移动");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("Vincent", "TouchEventTestActivity 事件：取消");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("Vincent", "TouchEventTestActivity 事件：抬起");
                break;
        }
        return super.onTouchEvent(event);
    }
}
