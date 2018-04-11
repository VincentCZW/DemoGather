package com.example.annotation_tool.demogather.effect;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.annotation_tool.demogather.R;

/**
 * Created by vincent on 2018/2/1.
 *
 * sp 导致的内存 和 ui卡顿问题
 *
 * 涉及 1. commit 和  apply区别  2. sp缓存
 */

public class SPMainActivity extends Activity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sp_main_layout);

        findViewById(R.id.load_sp).setOnClickListener(clickListener);
        findViewById(R.id.save_sp_1).setOnClickListener(clickListener);
        findViewById(R.id.save_sp_2).setOnClickListener(clickListener);
        findViewById(R.id.save_sp_3).setOnClickListener(clickListener);
    }

    private void loadSP() {
        long startTime = System.currentTimeMillis();
        sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        String s = sharedPreferences.getString("stringKey1", "default");
        Log.d("Vincent","s = " +s);
        long middleTime1 = System.currentTimeMillis();
        Log.d("Vincent", "load time = " + (middleTime1 - startTime));
    }

    private void saveSP() {
        long startTime = System.currentTimeMillis();
        for (int i = 200 ; i < 300; i++) {
            Log.d("Vincent"," time S = " + System.currentTimeMillis());
            editor.putString("stringKey" + i, getString());
            editor.commit();
            Log.d("Vincent"," time E = " + System.currentTimeMillis());
        }
        long middleTime1 = System.currentTimeMillis();
        Log.d("Vincent", "time1 = " + (middleTime1 - startTime));

    }

    private void saveSP2() {
        long startTime = System.currentTimeMillis();
        for (int i = 300 ; i < 400; i++) {
            Log.d("Vincent"," time S = " + System.currentTimeMillis());
            editor.putString("stringKey" + i, getString());
            Log.d("Vincent"," time E = " + System.currentTimeMillis());
        }
        editor.commit();
        long middleTime1 = System.currentTimeMillis();
        Log.d("Vincent", "time2 = " + (middleTime1 - startTime));
    }

    private void saveSP3() {
        long startTime = System.currentTimeMillis();
        editor.putString("stringKey21", getString());
        editor.commit();
        Log.d("Vincent","3, commitTime = " + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        editor.putString("stringKey22",getString());
        editor.apply();
        Log.d("Vincent","3, applyTime = " + (System.currentTimeMillis() - startTime));
    }

    private String getString() {
        String tag = "sdfsldfjl;sfj;lsjldfjsadfj;lsjdl;fjlasjdfljslajdfjsjdf" +
                "sdfljsl;fj;lajsldfj;ls" +
                "sdfl;jas'ldjfwoeporiq]erkfjn;vlsajf'wnrbmgewkfkwepfjkwkefjk" +
                "pq[kf" +
                "lfw;fljw'lkejf'" +
                "efkqeoj;fljs'wjef" +
                "[pefopjg;kl'fkwq[rpkpglksjflksddddkljflkjwe;jfoiwjefwjlekfjwef" +
                "wlefjlkwjef;kwjefkjw;elfj;wkejf;lkwje;fj;lkwje;lfj;lkwje;fkljw;lefop" +
                "lsflkjwlejflwje;lfjwlejfl;wj;elfjlsndfmnasfn;ojwe;fj;awklf;ljojwefnwfw" +
                "klsf;ljw;lekj;ennv;n;fwkefowejfljwe;kfj;kljf;as" +
                "lsjflwje[jmfn'kl'f;lskajf;jerlk;jfj;lsdjf;lkj;lj;dff" +
                "flwjef;lksj;fkdsf";
        return  tag;
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.load_sp:
                    loadSP();
                    break;
                case R.id.save_sp_1:
                    saveSP();
                    break;
                case R.id.save_sp_2:
                    saveSP2();
                    break;
                case R.id.save_sp_3:
                    saveSP3();
                    break;
            }
        }
    };
}
