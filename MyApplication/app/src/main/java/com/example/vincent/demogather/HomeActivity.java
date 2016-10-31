package com.example.vincent.demogather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.vincent.demogather.activity.TouchEventTestActivity;

public class HomeActivity extends Activity {

    private Button btnTouchEventTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Log.d("Vincent", "Home onCreate");
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(HomeActivity.this, OtherActivity.class);
//                HomeActivity.this.startActivity(intent);
//            }
//        }, 2500);

        initViews();
        bindListener();
    }

    private void initViews() {
        btnTouchEventTest = (Button) findViewById(R.id.touch_event_test);
    }

    private void bindListener() {
        btnTouchEventTest.setOnClickListener(clickListener);
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
