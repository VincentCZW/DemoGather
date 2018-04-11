package com.example.annotation_tool.demogather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.annotation_tool.demogather.android.StorageDirMainActivity;

/**
 * Created by VincentChen on 2017/6/27.
 */
public class AndroidMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_main_layout);

        findViewById(R.id.btn_storage).setOnClickListener(clickListener);

        Log.d("Vincent", "develop test 3");

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_storage:
                    intent = new Intent(AndroidMainActivity.this, StorageDirMainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
