package com.example.annotation_tool.demogather.event_bus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.annotation_tool.demogather.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by VincentChen on 2017/6/22.
 */
public class EventBusMainActivity extends Activity {

    private Button openSecondActivity;
    private TextView eventBusContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus_main_layout);
        initViews();
        bindEvent();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onRecvEvent1(TestEvent event) {
        Log.d("Vincent", "onRecvEvent1  --  ThreadMode.POSTING" + "  --  " + Thread.currentThread().getName());
        eventBusContent.setText(event.msg);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRecvEvent2(TestEvent event) {
        Log.d("Vincent", "onRecvEvent1  --  ThreadMode.MAIN" + "  --  " + Thread.currentThread().getName());
        eventBusContent.setText(event.msg);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onRecvEvent3(TestEvent event) {
        Log.d("Vincent", "onRecvEvent1  --  ThreadMode.BACKGROUND" + "  --  " + Thread.currentThread().getName());
        eventBusContent.setText(event.msg);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onRecvEvent4(TestEvent event) {
        Log.d("Vincent", "onRecvEvent1  --  ThreadMode.ASYNC" + "  --  " + Thread.currentThread().getName());
        eventBusContent.setText(event.msg);
    }

    private void initViews() {
        openSecondActivity = (Button) findViewById(R.id.open_event_bus_activity);
        eventBusContent = (TextView) findViewById(R.id.event_bus_content);
    }

    private void bindEvent() {
        openSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventBusMainActivity.this, EventBusSecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
