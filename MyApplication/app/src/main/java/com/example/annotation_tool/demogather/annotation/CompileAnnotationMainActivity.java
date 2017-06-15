package com.example.annotation_tool.demogather.annotation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.AnnoField;
import com.example.AnnoMethod;
import com.example.annotation_tool.AnnotationTool;
import com.example.annotation_tool.demogather.R;

/**
 * Created by VincentChen on 2017/6/14.
 *
 * 编译时注解demo
 */
public class CompileAnnotationMainActivity extends Activity {

    @AnnoField("people")
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compile_anntation_layout);
        generateJavaTest();
    }


    @AnnoMethod()
    private void generateJavaTest() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AnnotationTool.getInstance().inject(CompileAnnotationMainActivity.this);
            }
        }, 1500);
    }
}
