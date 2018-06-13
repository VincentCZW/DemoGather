package com.example.annotation_tool.demogather.effect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.annotation_tool.demogather.BaseActivity;
import com.example.annotation_tool.demogather.R;

/**
 * Created by vincent on 2018/1/12.
 */

public class EffectMainActivity extends BaseActivity {

    private Button memoryBtn;
    private Button uiBlockBtn;
    private Button spBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.effect_main_layout);
        initViews();
        bindEvent();
    }


    private void initViews() {
        memoryBtn = (Button) findViewById(R.id.memory);
        uiBlockBtn = (Button) findViewById(R.id.ui_block);
        spBtn = (Button) findViewById(R.id.sp);
    }

    private void bindEvent() {
        memoryBtn.setOnClickListener(clickListener);
        uiBlockBtn.setOnClickListener(clickListener);
        spBtn.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.memory:
                    intent = new Intent(EffectMainActivity.this, MemoryActivity.class);
                    startActivity(intent);
                    break;
                case R.id.ui_block:
                    intent = new Intent(EffectMainActivity.this, UiBlockMainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.sp:
                    intent = new Intent(EffectMainActivity.this, SPMainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
