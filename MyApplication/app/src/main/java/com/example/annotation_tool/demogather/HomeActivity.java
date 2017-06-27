package com.example.annotation_tool.demogather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.annotation_tool.demogather.hotfix.HotFixActivity;
import com.example.annotation_tool.demogather.muti_thread.MutiThreadTestMainActivity;
import com.example.annotation_tool.demogather.activity.TouchEventTestActivity;
import com.example.annotation_tool.demogather.anr.ANRMainActivity;
import com.example.annotation_tool.demogather.diy_view.DiyViewMainActivity;
import com.example.annotation_tool.demogather.java.JavaMainActivity;

public class HomeActivity extends Activity {

    private Button btnTouchEventTest;
    private Button btnMutiThread;
    private Button diyViewTest;
    private Button anrTest;
    private Button androidTest;
    private Button javaTest;
    private Button hotFixTest;
    private Button openStructureTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        bindListener();
    }

    private void initViews() {
        btnTouchEventTest = (Button) findViewById(R.id.touch_event_test);
        btnMutiThread = (Button) findViewById(R.id.muti_thread_test);
        diyViewTest = (Button) findViewById(R.id.diy_view_test);
        anrTest = (Button) findViewById(R.id.anr_test);
        androidTest = (Button) findViewById(R.id.android_test);
        javaTest = (Button) findViewById(R.id.java_test);
        hotFixTest = (Button) findViewById(R.id.hot_fix);
        openStructureTest = (Button) findViewById(R.id.android_develop_structure);
    }

    private void bindListener() {
        btnTouchEventTest.setOnClickListener(clickListener);
        btnMutiThread.setOnClickListener(clickListener);
        diyViewTest.setOnClickListener(clickListener);
        anrTest.setOnClickListener(clickListener);
        androidTest.setOnClickListener(clickListener);
        javaTest.setOnClickListener(clickListener);
        hotFixTest.setOnClickListener(clickListener);
        openStructureTest.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.touch_event_test:
                    intent = new Intent(HomeActivity.this, TouchEventTestActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.muti_thread_test:
                    intent = new Intent(HomeActivity.this, MutiThreadTestMainActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.diy_view_test:
                    intent = new Intent(HomeActivity.this, DiyViewMainActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.anr_test:
                    intent = new Intent(HomeActivity.this, ANRMainActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.android_test:
                    intent = new Intent(HomeActivity.this, AndroidMainActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.java_test:
                    intent = new Intent(HomeActivity.this, JavaMainActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.hot_fix:
                    intent = new Intent(HomeActivity.this, HotFixActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.android_develop_structure:
                    intent = new Intent(HomeActivity.this, OpenStructureMainActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Vincent", "Home onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Vincent", "Home onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Vincent", "Home onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Vincent", "Home onPuase");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Vincent", "Home onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Vincent", "Home onDestroy");
    }
}
