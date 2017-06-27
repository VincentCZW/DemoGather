package com.example.annotation_tool.demogather.event_bus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.annotation_tool.demogather.R;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by VincentChen on 2017/6/22.
 */
public class EventBusSecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus_second_layout);

        findViewById(R.id.send_event).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestEvent testEvent = new TestEvent();
                testEvent.msg = "event bus 信息";
                EventBus.getDefault().post(testEvent);
            }
        });
    }
}
