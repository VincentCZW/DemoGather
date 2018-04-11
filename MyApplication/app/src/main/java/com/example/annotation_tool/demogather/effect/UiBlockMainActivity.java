package com.example.annotation_tool.demogather.effect;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.annotation_tool.demogather.R;

/**
 * Created by vincent on 2018/1/19.
 */
public class UiBlockMainActivity extends Activity {

    private Button uiBlockBtn;
    private Button uiFpsBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_block_main_layout);
        initViews();
        bindEvents();
    }

    private void initViews() {
        uiBlockBtn = (Button) findViewById(R.id.ui_block_test);
        uiFpsBtn = (Button) findViewById(R.id.ui_list_fps);
    }

    private void bindEvents() {
        uiBlockBtn.setOnClickListener(clickListener);
        uiFpsBtn.setOnClickListener(clickListener);
    }

    private void produceUIBlock() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getCurrStackTrace() {
        StackTraceElement [] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements != null) {
            for (int i = 0 ; i < stackTraceElements.length; ++i) {
                Log.d("Vincent", "stackTraceElement = " + stackTraceElements.toString());
            }
        }
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ui_block_test:
                    produceUIBlock();
                    getCurrStackTrace();
                    break;
                case R.id.ui_list_fps:
                    break;
            }
        }
    };
}
