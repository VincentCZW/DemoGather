package com.example.annotation_tool.demogather.java;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.annotation_tool.demogather.R;
import com.example.annotation_tool.demogather.annotation.AnnotationMainActivity;
import com.example.annotation_tool.demogather.java.entity.StaticClass;

/**
 * Created by VincentChen on 2017/4/22.
 */
public class JavaMainActivity extends Activity {


    private Button staticInitBtn;
    private Button annotationBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_main_layout);
        initViews();
        bindEvent();
    }

    private void initViews() {
        staticInitBtn = (Button) findViewById(R.id.static_init_btn);
        annotationBtn = (Button) findViewById(R.id.annotation_btn);
    }

    private void bindEvent() {
        staticInitBtn.setOnClickListener(clickListener);
        annotationBtn.setOnClickListener(clickListener);
    }

    private void testStaticInit() {
        StaticClass.print();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.static_init_btn:
                    testStaticInit();
                    break;
                case R.id.annotation_btn:
                    intent = new Intent(JavaMainActivity.this, AnnotationMainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
