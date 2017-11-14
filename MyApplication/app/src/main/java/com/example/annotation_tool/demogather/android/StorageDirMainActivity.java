package com.example.annotation_tool.demogather.android;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

import com.example.annotation_tool.demogather.R;
import com.example.annotation_tool.demogather.common.VincentLog;

/**
 * Created by VincentChen on 2017/6/27.
 */
public class StorageDirMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_layout);
        printStorage();
    }

    private void printStorage() {
        VincentLog.logD("getExternalCacheDir() = ", getExternalCacheDir().toString());
        VincentLog.logD("getExternalCacheDirs() = ", getExternalCacheDirs().toString());
        VincentLog.logD("getExternalFilesDir() = ", getExternalFilesDir(Environment.DIRECTORY_PICTURES).toString());
        VincentLog.logD("getExternalFilesDir() = ", getExternalFilesDir(Environment.DIRECTORY_DCIM).toString());
        VincentLog.logD("getExternalFilesDirs() = ", getExternalFilesDirs(Environment.DIRECTORY_DCIM).toString());

        VincentLog.logD("getFilesDir() = ", getFilesDir().toString());
        VincentLog.logD("getCacheDir() = ", getCacheDir().toString());

        VincentLog.logD("Environment.getExternalStorageDirectory() = ", Environment.getExternalStorageDirectory().toString());

        VincentLog.logD("Environment.getExternalStoragePublicDirectory() = ", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString());
    }
}
