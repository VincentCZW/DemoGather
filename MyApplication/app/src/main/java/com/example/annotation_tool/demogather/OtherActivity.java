package com.example.annotation_tool.demogather;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.annotation_tool.demogather.application.DemoApplication;
import com.example.annotation_tool.demogather.test.IPCData;

/**
 * Created by VincentChen on 2016/10/17.
 */
public class OtherActivity extends Activity {

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_act_layout);
        Log.d("Vincent", "Other onCreate " + "time = " + System.currentTimeMillis());
        Log.d("Vincent","Application (other) = " + DemoApplication.getContext().toString());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showDialog();
            }
        },1500);
    }

    @Override
    protected void onStart() {
        Log.d("Vincent", "Other onStart");
        getIPCData();
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Vincent", "Other onResume");
        ViewServer.get(this).setFocusedWindow(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("Vincent", "Other onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("Vincent", "Other onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Vincent", "Other onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Vincent", "Other onPuase");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Vincent", "Other onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Vincent", "Other onDestroy");
        ViewServer.get(this).removeWindow(this);
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("dialog");
        dialog  = builder.create();
        dialog.show();
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

    private void hideDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

}
