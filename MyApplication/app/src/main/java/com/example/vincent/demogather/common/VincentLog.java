package com.example.vincent.demogather.common;

import android.util.Log;

/**
 * Created by VincentChen on 2017/4/22.
 */
public class VincentLog {

    public static void logD(String key, String value) {
        Log.d("Vincent", key + "：" + value);
    }

    public static void logD(String key) {
        Log.d("Vincent", key);
    }

    public static void logE(String key, String value) {
        Log.e("Vincent", key + "：" + value);
    }

    public static void logE(String key) {
        Log.e("Vincent", key);
    }
}
