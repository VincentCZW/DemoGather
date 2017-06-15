package com.example.annotation_tool.demogather.butter_knife;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.annotation_tool.demogather.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by VincentChen on 2017/6/12.
 */
public class ButterKnifeMainActivity extends FragmentActivity {


    @BindView(R.id.btn)
    protected Button Btn;

    @BindView(R.id.butter_knife_fragment_container)
    protected FrameLayout butterKnifeFragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife_main_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void onBtnClick() {
        Toast.makeText(this, "ButterKnife Click", Toast.LENGTH_SHORT).show();
        ButterKnifeFragment fragment = new ButterKnifeFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.butter_knife_fragment_container, fragment);
        transaction.commit();
    }
}
