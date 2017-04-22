package com.example.vincent.demogather.java;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vincent.demogather.R;
import com.example.vincent.demogather.java.entity.StaticClass;

/**
 * Created by VincentChen on 2017/4/22.
 */
public class JavaMainActivity extends Activity {


    private Button staticInitBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_main_layout);
        initViews();
        bindEvent();
    }

    private void initViews() {
        staticInitBtn = (Button) findViewById(R.id.static_init_btn);
    }

    private void bindEvent() {
        staticInitBtn.setOnClickListener(clickListener);
    }

    private void testStaticInit() {
        StaticClass.print();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.static_init_btn:
                    testStaticInit();
                    break;
            }
        }
    };
}
