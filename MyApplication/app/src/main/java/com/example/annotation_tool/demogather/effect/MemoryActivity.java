package com.example.annotation_tool.demogather.effect;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.annotation_tool.demogather.R;

/**
 * Created by vincent on 2018/1/12.
 */

public class MemoryActivity extends Activity {

    private static MemoryLeakClass leakClass = null;

    private Button loadBitmaoBtn;
    private Button innerClassLeakBtn;
    private ImageView imageView;

    private Bitmap bitmap;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_main_layout);
        initViews();
        bindEvent();
    }

    private void loadBitmap() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.welcome_bg);
        imageView.setImageBitmap(bitmap);
    }

    private void initViews() {
        loadBitmaoBtn = (Button) findViewById(R.id.load_bitmap);
        innerClassLeakBtn = (Button) findViewById(R.id.inner_class);
        imageView = (ImageView) findViewById(R.id.image);
    }

    private void bindEvent() {
        loadBitmaoBtn.setOnClickListener(clickListener);
        innerClassLeakBtn.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.load_bitmap:
                    loadBitmap();
                    break;
                case R.id.inner_class:
                    leakClass = new MemoryLeakClass();
                    break;
            }
        }
    };

    private class MemoryLeakClass {

    }
}
