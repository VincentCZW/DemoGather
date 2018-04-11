package com.example.annotation_tool.demogather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.annotation_tool.demogather.application.DemoApplication;
import com.example.annotation_tool.demogather.common.Variable;
import com.example.annotation_tool.demogather.common.VincentLog;
import com.example.annotation_tool.demogather.effect.EffectMainActivity;
import com.example.annotation_tool.demogather.hotfix.HotFixActivity;
import com.example.annotation_tool.demogather.muti_thread.MutiThreadTestMainActivity;
import com.example.annotation_tool.demogather.activity.TouchEventTestActivity;
import com.example.annotation_tool.demogather.anr.ANRMainActivity;
import com.example.annotation_tool.demogather.diy_view.DiyViewMainActivity;
import com.example.annotation_tool.demogather.java.JavaMainActivity;
import com.example.annotation_tool.demogather.test.A;
import com.example.annotation_tool.demogather.test.IPCData;

public class HomeActivity extends Activity {

    private View mContentView;

    private Button btnTouchEventTest;
    private Button btnMutiThread;
    private Button diyViewTest;
    private Button anrTest;
    private Button androidTest;
    private Button javaTest;
    private Button hotFixTest;
    private Button openStructureTest;
    private Button effectOptimizeTest;
    private Button otherTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Vincent", "Home onCreate " + "time = " + System.currentTimeMillis());
        Log.d("Vincent","Application (Home) = " + DemoApplication.getContext().toString());

        new Thread(new Runnable() {
            @Override
            public void run() {
                long time1 = System.currentTimeMillis();
                mContentView = View.inflate(HomeActivity.this, R.layout.activity_home, null);
                Log.d("Vincent", "inflate 用时 = " + (System.currentTimeMillis() - time1));
            }
        }).start();

        Log.d("Vincent", "test 1");
        Log.d("Vincent", "test 2");
        try {
            Thread.sleep(90);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setContentView(mContentView);

        ViewServer.get(this).addWindow(this);

        initViews();
        bindListener();

//        Log.d("Vincent", "算法测试");
//        // 测试算法
//        int arr1 [] = {14,11};
//        int arr2 [] = {12,2,3,16,44,10,12,12};
//        quick_sort(arr1, 0,1);
//        quick_sort(arr2, 0, 7);
//        for (int i = 0 ; i < 2; ++i) {
//            Log.d("Vincent",arr1[i] + "");
//        }
//        Log.d("Vincent", "****************");
//        for (int i = 0 ; i < 8; ++i) {
//            Log.d("Vincent",arr2[i] + "");
//        }


//        A a = new A();
//        A.B b = a.new B();
//        A.B.C c = b.new C();
//        A.B.C.F f = c.new F();
//
//        A.D d = new A.D();
//        A.D.E e = d.new E();
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            VincentLog.logD("hasFocus = " + hasFocus);
            Log.d("Vincent","测试UI是否绘制完成 width = " + btnTouchEventTest.getWidth());
        }
        Variable.addEndTime = System.currentTimeMillis();
        VincentLog.logD("startTotalTime = " + (Variable.addEndTime - Variable.appStartTime));
        super.onWindowFocusChanged(hasFocus);
    }

    private void initViews() {
        btnTouchEventTest = (Button) findViewById(R.id.touch_event_test);
        btnMutiThread = (Button) findViewById(R.id.muti_thread_test);
        diyViewTest = (Button) findViewById(R.id.diy_view_test);
        anrTest = (Button) findViewById(R.id.anr_test);
        androidTest = (Button) findViewById(R.id.android_test);
        javaTest = (Button) findViewById(R.id.java_test);
        hotFixTest = (Button) findViewById(R.id.hot_fix);
        openStructureTest = (Button) findViewById(R.id.android_develop_structure);
        effectOptimizeTest = (Button) findViewById(R.id.effect_optimize);
        otherTest = (Button) findViewById(R.id.other);
    }

    private void bindListener() {
        btnTouchEventTest.setOnClickListener(clickListener);
        btnMutiThread.setOnClickListener(clickListener);
        diyViewTest.setOnClickListener(clickListener);
        anrTest.setOnClickListener(clickListener);
        androidTest.setOnClickListener(clickListener);
        javaTest.setOnClickListener(clickListener);
        hotFixTest.setOnClickListener(clickListener);
        openStructureTest.setOnClickListener(clickListener);
        effectOptimizeTest.setOnClickListener(clickListener);
        otherTest.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.touch_event_test:
                    intent = new Intent(HomeActivity.this, TouchEventTestActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.muti_thread_test:
                    intent = new Intent(HomeActivity.this, MutiThreadTestMainActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.diy_view_test:
                    intent = new Intent(HomeActivity.this, DiyViewMainActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.anr_test:
                    intent = new Intent(HomeActivity.this, ANRMainActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.android_test:
                    intent = new Intent(HomeActivity.this, AndroidMainActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.java_test:
                    intent = new Intent(HomeActivity.this, JavaMainActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.hot_fix:
                    intent = new Intent(HomeActivity.this, HotFixActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.android_develop_structure:
                    intent = new Intent(HomeActivity.this, OpenStructureMainActivity.class);
                    HomeActivity.this.startActivity(intent);
                    break;
                case R.id.effect_optimize:
                    intent = new Intent(HomeActivity.this, EffectMainActivity.class);
                    HomeActivity.this.startActivity(intent);
                case R.id.other:
                    IPCData data = new IPCData();
                    data.name = "Vincent";
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("ipc_data", data);
                    intent = new Intent(HomeActivity.this, OtherActivity.class);
                    intent.putExtras(bundle);
                    HomeActivity.this.startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onStart() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        super.onStart();
        Log.d("Vincent", "Home onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Vincent", "Home onResume");
        ViewServer.get(this).setFocusedWindow(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("Vincent", "Home onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("Vincent", "Home onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Vincent", "Home onRestart");
        Log.d("Vincent","Application (Home) = " + DemoApplication.getContext().toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Vincent", "Home onPuase");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Vincent", "Home onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Vincent", "Home onDestroy");
        ViewServer.get(this).removeWindow(this);
    }

    public void quick_sort(int arr[], int s, int e) {
        if(s < e) {
            int tmp = arr[s];
            int i = s;
            int j = e;
            while(i < j) {
                while(i < j && arr[j] > tmp) {
                    j--;
                }
                while(i < j && arr[i] < tmp) {
                    i++;
                }
                if(i < j) {
                    swap(arr[i],arr[j]);
                    i++;
                    j--;
                }
            }
            swap(arr[s],arr[i - 1]);
            quick_sort(arr,s,i - 2);
            quick_sort(arr,i, e);
          }
    }

    void swap(int x,int y) {
        x = x + y;
        y = x - y;
        x = x - y;
    }
}
