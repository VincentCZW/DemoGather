package com.example.annotation_tool.demogather.hotfix;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by VincentChen on 2017/6/6.
 */
public class FixedClass {

    private static int a = 6;
    private static int b = 0;

    public static void fix(Context context) {
        Toast.makeText(context, "a / b = " + a / b, Toast.LENGTH_SHORT).show();
    }
}
