package com.example.annotation_tool.demogather.muti_thread;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.annotation_tool.demogather.Object.SychronizedObject;
import com.example.annotation_tool.demogather.R;

/**
 * Created by VincentChen on 2016/11/2.
 */
public class SychronizedTestActivity extends Activity {

    private Button btn1;

    private Button btn2;

    private Button btn3;

    private Button btn4;

    private Button btn5;

    private Button btn6;

    private Button btn7;


    private SychronizedObject sychronizedObjectOne = new SychronizedObject("ONE");

    private SychronizedObject sychronizedObjectTwo = new SychronizedObject("Two");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sychronnized_test_layout);
        findViews();
        bindListeners();
        testThreadRun();
    }

    private void testThreadRun() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread1 run");
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread2 run");
            }
        };
        thread1.start();
        thread2.start();
    }

    private void findViews() {
        btn1 = (Button) findViewById(R.id.sychronized_test_1);
        btn2 = (Button) findViewById(R.id.sychronized_test_2);
        btn3 = (Button) findViewById(R.id.sychronized_test_3);
        btn4 = (Button) findViewById(R.id.sychronized_test_4);
        btn5 = (Button) findViewById(R.id.sychronized_test_5);
        btn6 = (Button) findViewById(R.id.sychronized_test_6);
        btn7 = (Button) findViewById(R.id.sychronized_test_7);
    }

    private void bindListeners() {
        btn1.setOnClickListener(clickListener);
        btn2.setOnClickListener(clickListener);
        btn3.setOnClickListener(clickListener);
        btn4.setOnClickListener(clickListener);
        btn5.setOnClickListener(clickListener);
        btn6.setOnClickListener(clickListener);
        btn7.setOnClickListener(clickListener);
    }

    private void testOne() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread1 run");
                sychronizedObjectOne.recycleLog1();
                Log.d("Vincent", "recycleLog1 complete");
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread2 run");
                sychronizedObjectOne.recycleLog1();
            }
        };
        thread2.start();
        thread1.start();
    }

    private void testTwo() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread1 run");
                sychronizedObjectOne.recycleLog1();
                Log.d("Vincent", "recycleLog1 complete");
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread2 run");
                sychronizedObjectOne.recycleLog2();
            }
        };
        thread1.start();
        thread2.start();
    }

    private void testThree() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread1 run");
                sychronizedObjectOne.recycleLog1();
                Log.d("Vincent", "recycleLog1 complete");
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread2 run");
                sychronizedObjectOne.recycleLog4();
            }
        };
        thread1.start();
        thread2.start();
    }

    private void testFour() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread1 run");
                sychronizedObjectOne.recycleLog1();
                Log.d("Vincent", "recycleLog1 complete");
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread2 run");
                sychronizedObjectTwo.recycleLog4();
            }
        };
        thread1.start();
        thread2.start();
    }

    private void testFive() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread1 run");
                sychronizedObjectOne.recycleLog1();
                Log.e("Vincent", "recycleLog1 complete");
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                Log.e("Vincent", "thread2 run");
                SychronizedObject.recycleLog5();
            }
        };
        thread1.start();
        thread2.start();
    }

    private void testSix() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Log.e("Vincent", "thread1 run");
                SychronizedObject.recycleLog5();
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                Log.e("Vincent", "thread2 run");
                SychronizedObject.recycleLog6();
            }
        };
        thread1.start();
        thread2.start();
    }

    private void testSeven() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread1 run");
                SychronizedObject.recycleLog5();
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                Log.d("Vincent", "thread2 run");
                SychronizedObject.recycleLog5();
            }
        };
        thread1.start();
        thread2.start();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sychronized_test_1:
                    testOne();
                    break;
                case R.id.sychronized_test_2:
                    testTwo();
                    break;
                case R.id.sychronized_test_3:
                    testThree();
                    break;
                case R.id.sychronized_test_4:
                    testFour();
                    break;
                case R.id.sychronized_test_5:
                    testFive();
                    break;
                case R.id.sychronized_test_6:
                    testSix();
                    break;
                case R.id.sychronized_test_7:
                    testSeven();
                    break;
            }
        }
    };

}
