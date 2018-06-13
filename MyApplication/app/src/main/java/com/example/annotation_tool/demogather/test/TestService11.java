package com.example.annotation_tool.demogather.test;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.annotation_tool.demogather.R;

import static com.example.annotation_tool.demogather.OtherActivity.ACTION_INCREASE_MEMORY;

/**
 * Created by vincent on 2018/5/24.
 */

public class TestService11 extends Service {

    private BigObj[] array = new BigObj[1000];

    private int index = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        registerReceiver(receiver, new IntentFilter(ACTION_INCREASE_MEMORY));
        for (int i = 0 ; i < 10 ; i++) {
            array[i] = new BigObj();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            array[i].bitmapl = BitmapFactory.decodeResource(getResources(), R.drawable.welcome_bg);
        }
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void increaseMemory() {
        index++;
        for (int i = index * 10 ; i < index * 10 + 10 ; i++) {
            array[i] = new BigObj();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            array[i].bitmapl = BitmapFactory.decodeResource(getResources(), R.drawable.welcome_bg);
        }
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            increaseMemory();
        }
    };

    public static class BigObj {
        public Bitmap bitmapl;
    }
}
