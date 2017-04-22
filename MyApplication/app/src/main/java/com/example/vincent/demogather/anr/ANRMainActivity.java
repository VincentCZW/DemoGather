package com.example.vincent.demogather.anr;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.vincent.demogather.R;

/**
 * Created by VincentChen on 2017/4/20.
 */
public class ANRMainActivity extends Activity {

    private Button dispatchEventBtn;
    private Button broadcastBtn;
    private Button serviceBtn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anr_main_layout);
        initViews();
        bindEvent();
        registerReceiver(receiver, new IntentFilter("anr_receiver"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    private void initViews() {
        dispatchEventBtn = (Button) findViewById(R.id.dispatch_event_anr);
        broadcastBtn = (Button) findViewById(R.id.broadcast_receiver_anr);
        serviceBtn = (Button) findViewById(R.id.service_anr);
    }

    private void bindEvent() {
        dispatchEventBtn.setOnClickListener(clickListener);
        broadcastBtn.setOnClickListener(clickListener);
        serviceBtn.setOnClickListener(clickListener);
    }

    private void makeDispatchEventAnr() {
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    private void makeBroadcastAnr() {
        sendBroadcast(new Intent("anr_receiver"));
    }

    private void makeServiceAnr() {

    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                Log.d("Vincent", "收到广播");
                Thread.sleep(20 * 1000);
                Log.d("Vincent", "广播结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.dispatch_event_anr:
                    makeDispatchEventAnr();
                    break;
                case R.id.broadcast_receiver_anr:
                    makeBroadcastAnr();
                    break;
                case R.id.service_anr:
                    makeServiceAnr();
                    break;
            }
        }
    };
}
