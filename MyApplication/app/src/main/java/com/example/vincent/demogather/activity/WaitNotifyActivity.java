package com.example.vincent.demogather.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.example.vincent.demogather.Object.SychronizedObject;
import com.example.vincent.demogather.R;

/**
 * Created by VincentChen on 2016/11/2.
 */
public class WaitNotifyActivity extends Activity {

    private SychronizedObject sychronizedObject1 = new SychronizedObject("test1");

    private SychronizedObject sychronizedObject2 = new SychronizedObject("test2");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wait_notify_layout);
        findViewById(R.id.wait_notify_test_1).setOnClickListener(clickListener);
        findViewById(R.id.wait_notify_test_2).setOnClickListener(clickListener);
        findViewById(R.id.wait_notify_test_3).setOnClickListener(clickListener);
        findViewById(R.id.wait_notify_test_4).setOnClickListener(clickListener);
    }

    private void test1() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread1 run");
                synchronized (sychronizedObject1) {
                    sychronizedObject1.recycleLog1();
                    try {
                        sychronizedObject1.wait();
                        sychronizedObject1.recycleLog1();
                        sychronizedObject1.notify();
                        sleep(2000);
                        Log.d("Vincent", "thread1 complete");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        final Thread thread2 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread2 run");
                synchronized (sychronizedObject1) {
                    sychronizedObject1.recycleLog2();
                    try {
                        sychronizedObject1.notify();
                        sleep(5000);
                        sychronizedObject1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sychronizedObject1.recycleLog2();
                }
            }
        };

        thread1.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                thread2.start();

            }
        }, 1000);
    }

    private void test2() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread1 run");
                synchronized (sychronizedObject1) {
                    sychronizedObject1.recycleLog1();
                    try {
                        Log.d("Vincent", "thread1 wait 3000");
                        sychronizedObject1.wait(3000);
                        sychronizedObject1.recycleLog1();
                        sychronizedObject1.notify();
                        sleep(2000);
                        Log.d("Vincent", "thread1 complete");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        final Thread thread2 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread2 run");
                synchronized (sychronizedObject1) {
                    sychronizedObject1.recycleLog2();
                    try {
                        Log.d("Vincent", "thread2 sleep 5000");
                        sleep(5000);
                        Log.d("Vincent", "thread2 wait");
                        sychronizedObject1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sychronizedObject1.recycleLog2();
                }
            }
        };

        thread1.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                thread2.start();

            }
        }, 1000);
    }

    private void test3() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread1 run");
                synchronized (SychronizedObject.class) {
                    sychronizedObject1.recycleLog1();
                    try {
                        SychronizedObject.class.wait();
                        sychronizedObject1.recycleLog1();
                        SychronizedObject.class.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        final Thread thread2 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread2 run");
                synchronized (SychronizedObject.class) {
                    sychronizedObject1.recycleLog2();
                    try {
                        Log.d("Vincent", "thread2 wait");
                        SychronizedObject.class.notify();
                        SychronizedObject.class.wait();
                        sychronizedObject1.recycleLog2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread1.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                thread2.start();

            }
        }, 1000);
    }


    private void test4() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread1 run");
                synchronized (SychronizedObject.class) {
                    sychronizedObject1.recycleLog1();
                    try {
                        SychronizedObject.class.wait();
                        sychronizedObject1.recycleLog1();
                        SychronizedObject.class.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        final Thread thread2 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread2 run");
                sychronizedObject2.recycleLog5();
                synchronized (SychronizedObject.class) {
                    sychronizedObject2.recycleLog2();
                    try {
                        Log.d("Vincent", "thread2 wait");
                        SychronizedObject.class.notify();
                        SychronizedObject.class.wait();
                        sychronizedObject2.recycleLog2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread1.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                thread2.start();

            }
        }, 1000);
    }



    private View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.wait_notify_test_1:
                    test1();
                    break;
                case R.id.wait_notify_test_2:
                    test2();
                    break;
                case R.id.wait_notify_test_3:
                    test3();
                    break;
                case R.id.wait_notify_test_4:
                    test4();
                    break;
            }
        }
    };
}
