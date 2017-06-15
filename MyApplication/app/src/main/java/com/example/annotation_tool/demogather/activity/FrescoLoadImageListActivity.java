package com.example.annotation_tool.demogather.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.annotation_tool.demogather.R;
import com.example.annotation_tool.demogather.adapter.FrescoImageLoadAdapter;

/**
 * Created by VincentChen on 2016/10/31.
 */
public class FrescoLoadImageListActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fresco_load_image_list_layout);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new FrescoImageLoadAdapter(this));
    }
}
