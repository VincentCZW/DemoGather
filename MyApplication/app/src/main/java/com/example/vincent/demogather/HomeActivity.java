package com.example.vincent.demogather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.vincent.demogather.activity.FrescoLoadImageListActivity;
import com.example.vincent.demogather.activity.MutiThreadTestMainActivity;
import com.example.vincent.demogather.activity.RetrofitActivity;
import com.example.vincent.demogather.activity.TouchEventTestActivity;
import com.example.vincent.demogather.anr.ANRMainActivity;
import com.example.vincent.demogather.diy_view.DiyViewMainActivity;
import com.example.vincent.demogather.java.JavaMainActivity;

public class HomeActivity extends Activity {

    private Button btnTouchEventTest;
    private Button btnFrescoTest;
    private Button btnMutiThread;
    private Button btnRetrofitTest;
    private Button diyViewTest;
    private Button anrTest;
    private Button javaTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        bindListener();
    }

    private void initViews() {
        btnTouchEventTest = (Button) findViewById(R.id.touch_event_test);
        btnFrescoTest = (Button) findViewById(R.id.fresco_test);
        btnMutiThread = (Button) findViewById(R.id.muti_thread_test);
        btnRetrofitTest = (Button) findViewById(R.id.net_quest_test);
        diyViewTest = (Button) findViewById(R.id.diy_view_test);
        anrTest = (Button) findViewById(R.id.anr_test);
        javaTest = (Button) findViewById(R.id.java_test);
    }

    private void bindListener() {
        btnTouchEventTest.setOnClickListener(clickListener);
        btnFrescoTest.setOnClickListener(clickListener);
        btnMutiThread.setOnClickListener(clickListener);
        btnRetrofitTest.setOnClickListener(clickListener);
        diyViewTest.setOnClickListener(clickListener);
        anrTest.setOnClickListener(clickListener);
        javaTest.setOnClickListener(clickListener);
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
                case R.id.fresco_test:
                    intent = new Intent(HomeActivity.this, FrescoLoadImageListActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.muti_thread_test:
                    intent = new Intent(HomeActivity.this, MutiThreadTestMainActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.net_quest_test:
                    intent = new Intent(HomeActivity.this, RetrofitActivity.class);
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
                case R.id.java_test:
                    intent = new Intent(HomeActivity.this, JavaMainActivity.class);
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
