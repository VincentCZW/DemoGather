package com.example.annotation_tool;

import android.app.Activity;

/**
 * Created by VincentChen on 2017/6/15.
 */
public class AnnotationTool {

    private static AnnotationTool instance = null;

    public static AnnotationTool getInstance() {
        if (instance == null) {
            synchronized (AnnotationTool.class) {
                if (instance == null) {
                    instance = new AnnotationTool();
                }
            }
        }
        return instance;
    }

    private AnnotationTool() {

    }

    public void inject(Activity activity) {

    }
}
