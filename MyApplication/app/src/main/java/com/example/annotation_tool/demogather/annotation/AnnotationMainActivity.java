package com.example.annotation_tool.demogather.annotation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.annotation_tool.demogather.R;

/**
 * Created by VincentChen on 2017/6/14.
 *
 * 注解demo
 */
public class AnnotationMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation_main_layout);

        findViewById(R.id.compile_annotation).setOnClickListener(clickListener);
        findViewById(R.id.runtime_annotation).setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.compile_annotation:
                    intent = new Intent(AnnotationMainActivity.this, CompileAnnotationMainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.runtime_annotation:
                    break;
            }
        }
    };
}
