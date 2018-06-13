package com.example.annotation_tool.demogather;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by vincent on 2018/5/24.
 */

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Vincent", "onCreate()  "  + getComponentName().getClassName());
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("Vincent", "onSaveInstanceState()  "  + getComponentName().getClassName());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("Vincent", "onRestoreInstanceState()  "  + getComponentName().getClassName());
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d("Vincent", "onConfigurationChanged()  "  + getComponentName().getClassName());
        super.onConfigurationChanged(newConfig);
    }
}
