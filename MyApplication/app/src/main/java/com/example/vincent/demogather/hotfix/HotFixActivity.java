package com.example.vincent.demogather.hotfix;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vincent.demogather.R;

/**
 * Created by VincentChen on 2017/6/6.
 *
 * 热修复
 */
public class HotFixActivity extends Activity {

    private Button testBtn;
    private Button fixBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_fix_main_layout);
        initViews();
        bindEvent();
    }

    private void initViews() {
        testBtn = (Button) findViewById(R.id.test);
        fixBtn = (Button) findViewById(R.id.fix);
    }

    private void bindEvent() {
        testBtn.setOnClickListener(clickListener);
        fixBtn.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.test:
                    FixedClass.fix(HotFixActivity.this);
                    break;
                case R.id.fix:
                    break;
            }
        }
    };
}
