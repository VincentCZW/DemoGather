package com.example.vincent.demogather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import com.example.vincent.demogather.activity.FrescoLoadImageListActivity;
import com.example.vincent.demogather.activity.RetrofitActivity;
import com.example.vincent.demogather.butter_knife.ButterKnifeMainActivity;


/**
 * Created by VincentChen on 2017/6/13.
 *
 * 开源框架
 */
public class OpenStructureMainActivity extends Activity {

    private Button frescoBtn;
    private Button retrofitBtn;
    private Button butterKnifeBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_structure_main_layout);
        initViews();
        bindEvent();
    }

    private void initViews() {
        frescoBtn = (Button) findViewById(R.id.fresco_test);
        retrofitBtn = (Button) findViewById(R.id.retrofit_test);
        butterKnifeBtn = (Button) findViewById(R.id.butter_knife);
    }

    private void bindEvent() {
        frescoBtn.setOnClickListener(clickListener);
        retrofitBtn.setOnClickListener(clickListener);
        butterKnifeBtn.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch (v.getId()) {
                case R.id.fresco_test:
                    intent = new Intent(OpenStructureMainActivity.this, FrescoLoadImageListActivity.class);
                    startActivity(intent);
                    break;
                case R.id.retrofit_test:
                    intent = new Intent(OpenStructureMainActivity.this, RetrofitActivity.class);
                    startActivity(intent);
                    break;
                case R.id.butter_knife:
                    intent = new Intent(OpenStructureMainActivity.this, ButterKnifeMainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
