package com.example.vincent.demogather.application;

import android.app.Application;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by VincentChen on 2016/10/31.
 */
public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Vincent", "DemoApplication onCreate()");
        Fresco.initialize(this);
    }
}
