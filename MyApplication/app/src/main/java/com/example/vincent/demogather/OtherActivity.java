package com.example.vincent.demogather;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by VincentChen on 2016/10/17.
 */
public class OtherActivity extends Activity {

    private View view;

    private Handler mHander = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            Log.d("Vincent mHandler", "handle Message");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_act_layout);
        Log.d("Vincent", "Other onCreate");
        mHander.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("Vincent", "延时Handler");
                testHanderler();
            }
        }, 1500);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Vincent", "Other onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Vincent", "Other onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Vincent", "Other onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Vincent", "Other onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Vincent", "Other onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Vincent", "Other onDestroy");
    }

    private void testHanderler() {
        new Thread() {

            Handler handler;

            @Override
            public void run() {
                Looper.prepare();
                handler = new Handler() {

                    @Override
                    public void handleMessage(Message msg) {
                        Log.d("Vincent", "msg.what = " + msg.what);
                        ((TextView) findViewById(R.id.test_tv)).setText("success");
                    }
                };

                Message msg1 = Message.obtain();
                msg1.what = 11;
                handler.sendMessage(msg1);


                Message msg2 = Message.obtain();
                msg2.what = 12;
                mHander.sendMessage(msg2);

                Looper.loop();
            }
        }.start();
    }
}
