package com.example.annotation_tool.demogather;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.annotation_tool.demogather.application.DemoApplication;
import com.example.annotation_tool.demogather.test.IPCData;
import com.example.annotation_tool.demogather.test.TestService;
import com.example.annotation_tool.demogather.test.TestService1;
import com.example.annotation_tool.demogather.test.TestService10;
import com.example.annotation_tool.demogather.test.TestService11;
import com.example.annotation_tool.demogather.test.TestService12;
import com.example.annotation_tool.demogather.test.TestService13;
import com.example.annotation_tool.demogather.test.TestService14;
import com.example.annotation_tool.demogather.test.TestService15;
import com.example.annotation_tool.demogather.test.TestService16;
import com.example.annotation_tool.demogather.test.TestService17;
import com.example.annotation_tool.demogather.test.TestService18;
import com.example.annotation_tool.demogather.test.TestService19;
import com.example.annotation_tool.demogather.test.TestService2;
import com.example.annotation_tool.demogather.test.TestService20;
import com.example.annotation_tool.demogather.test.TestService3;
import com.example.annotation_tool.demogather.test.TestService4;
import com.example.annotation_tool.demogather.test.TestService5;
import com.example.annotation_tool.demogather.test.TestService6;
import com.example.annotation_tool.demogather.test.TestService7;
import com.example.annotation_tool.demogather.test.TestService8;
import com.example.annotation_tool.demogather.test.TestService9;

/**
 * Created by VincentChen on 2016/10/17.
 */
public class OtherActivity extends Activity {

    public static final String ACTION_INCREASE_MEMORY = "action_increase_memory";

    private Button startUserMemory;
    private Button increaseMemory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_act_layout);
        Log.d("Vincent", "Other onCreate " + "time = " + System.currentTimeMillis());
        Log.d("Vincent","Application (other) = " + DemoApplication.getContext().toString());

        initViews();
        bindListener();
    }

    private void initViews() {
        startUserMemory = (Button) findViewById(R.id.test_start_memory) ;
        increaseMemory = (Button) findViewById(R.id.test_improve_memory);
    }

    private void bindListener() {
        startUserMemory.setOnClickListener(clickListener);
        increaseMemory.setOnClickListener(clickListener);
    }

    @Override
    protected void onStart() {
        Log.d("Vincent", "Other onStart");
        getIPCData();
        super.onStart();
    }

    private void getIPCData() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                IPCData data = bundle.getParcelable("ipc_data");
                if (data != null) {
                    Log.d("Vincent", "ipcData.name = " + data.name);
                } else {
                    Log.d("Vincent","ipcData == null");
                }
            }
        } else {
            Log.d("Vincent", "intent = null");
        }
    }

    private void startUseMemory() {
        Intent intent0 = new Intent(this, TestService.class);
        startService(intent0);

        Intent intent1 = new Intent(this, TestService1.class);
        startService(intent1);

        Intent intent2 = new Intent(this, TestService2.class);
        startService(intent2);

        Intent intent3 = new Intent(this, TestService3.class);
        startService(intent3);

        Intent intent4 = new Intent(this, TestService4.class);
        startService(intent4);

        Intent intent5 = new Intent(this, TestService5.class);
        startService(intent5);

        Intent intent6 = new Intent(this, TestService6.class);
        startService(intent6);

        Intent intent7 = new Intent(this, TestService7.class);
        startService(intent7);

        Intent intent8 = new Intent(this, TestService8.class);
        startService(intent8);

        Intent intent9 = new Intent(this, TestService9.class);
        startService(intent9);

        Intent intent10 = new Intent(this, TestService10.class);
        startService(intent10);

        Intent intent11 = new Intent(this, TestService11.class);
        startService(intent11);

        Intent intent12 = new Intent(this, TestService12.class);
        startService(intent12);

        Intent intent13 = new Intent(this, TestService13.class);
        startService(intent13);

        Intent intent14 = new Intent(this, TestService14.class);
        startService(intent14);

        Intent intent15 = new Intent(this, TestService15.class);
        startService(intent15);

        Intent intent16 = new Intent(this, TestService16.class);
        startService(intent16);

        Intent intent17 = new Intent(this, TestService17.class);
        startService(intent17);

        Intent intent18 = new Intent(this, TestService18.class);
        startService(intent18);

        Intent intent19 = new Intent(this, TestService19.class);
        startService(intent19);

        Intent intent20 = new Intent(this, TestService20.class);
        startService(intent20);
    }

    private void increaseMemory() {
        sendBroadcast(new Intent(ACTION_INCREASE_MEMORY));
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.test_start_memory:
                    startUseMemory();
                    break;
                case R.id.test_improve_memory:
                    increaseMemory();
                    break;
            }
        }
    };
}
