package com.example.vincent.demogather.muti_thread;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vincent.demogather.R;

/**
 * Created by VincentChen on 2016/11/2.
 */
public class MutiThreadTestMainActivity extends Activity {

    private Button sychronizedBtn;

    private Button PCPatternBtn;

    private Button waitNotifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muti_thread_test_main_layout);
        findViews();
        bindListners();
    }

    private void findViews() {
        sychronizedBtn = (Button) findViewById(R.id.btn_sychronized_test);
        PCPatternBtn = (Button) findViewById(R.id.btn_produce_consume_test);
        waitNotifyBtn = (Button) findViewById(R.id.btn_wait_notify_test);
    }

    private void bindListners() {
        sychronizedBtn.setOnClickListener(clickListener);
        PCPatternBtn.setOnClickListener(clickListener);
        waitNotifyBtn.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent ;
            switch (v.getId()) {
                case R.id.btn_sychronized_test:
                    intent = new Intent(MutiThreadTestMainActivity.this, SychronizedTestActivity.class);
                    MutiThreadTestMainActivity.this.startActivity(intent);
                    break;
                case R.id.btn_wait_notify_test:
                    intent = new Intent(MutiThreadTestMainActivity.this, WaitNotifyActivity.class);
                    MutiThreadTestMainActivity.this.startActivity(intent);
                    break;
                case R.id.btn_produce_consume_test:
                    intent = new Intent(MutiThreadTestMainActivity.this, ConsumerProducerActivity.class);
                    MutiThreadTestMainActivity.this.startActivity(intent);
                    break;
            }
        }
    };
}
