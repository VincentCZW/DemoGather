package com.example.vincent.demogather.Object;

import android.util.Log;

/**
 * Created by VincentChen on 2016/11/2.
 */
public class SychronizedObject {

    public static int staticCount = 5;

    public int count = 5;

    public String name;

    public SychronizedObject(String name) {
        this.name = name;
    }


    synchronized public void recycleLog1() {
        for (int i = 0; i < count; ++i) {
            Log.e("Vincent", "SychronizedObject：" + name + "  函数名：recycleLog1()" + "  输出：" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized public void recycleLog2() {
        for (int i = 0; i < count; ++i) {
            Log.e("Vincent", "SychronizedObject：" + name + "  函数名：recycleLog2()" + "  输出：" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void recycleLog3() {
        for (int i = 0; i < count; ++i) {
            Log.e("Vincent", "SychronizedObject：" + name + "  函数名：recycleLog3()" + "  输出：" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void recycleLog4() {
        for (int i = 6 ; i < 10; i++) {
            Log.e("Vincent", "非synchronize修饰的代码段先执行");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (this) {
            for (int i = 0; i < count; ++i) {
                Log.e("Vincent", "SychronizedObject：" + name + "  函数名：recycleLog4()" + "  输出：" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i = 6 ; i < 8; i++) {
            Log.e("Vincent", " synchronized (this) 修饰的代码段后面代码执行");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized static public void recycleLog5() {
        for (int i = 0; i < staticCount; ++i) {
            Log.e("Vincent", "SychronizedObject：默认名字" + "  函数名：recycleLog5()" + "  输出：" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized static public void recycleLog6() {
        for (int i = 0; i < staticCount; ++i) {
            Log.e("Vincent", "SychronizedObject：默认名字" + "  函数名：recycleLog6()" + "  输出：" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
