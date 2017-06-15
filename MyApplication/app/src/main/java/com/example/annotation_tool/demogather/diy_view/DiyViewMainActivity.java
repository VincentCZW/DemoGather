package com.example.annotation_tool.demogather.diy_view;

import android.app.Activity;
import android.os.Bundle;

import com.example.annotation_tool.demogather.R;
import com.example.annotation_tool.demogather.diy_view.view.ShortVideoProgressBar;

/**
 * Created by VincentChen on 2017/4/11.
 */
public class DiyViewMainActivity extends Activity {

    private ShortVideoProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diy_view_main_layout);
        initViews();
    }

    private void initViews() {
        progressBar = (ShortVideoProgressBar) findViewById(R.id.short_video_progress_bar);
    }
}
