package com.example.annotation_tool.demogather.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.example.annotation_tool.demogather.BuildConfig;
import com.example.annotation_tool.demogather.common.Variable;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.github.moduth.blockcanary.BlockCanary;
import com.github.moduth.blockcanary.BlockCanaryContext;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by VincentChen on 2016/10/31.
 */
public class DemoApplication extends Application {

    private static Application mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Vincent", "DemoApplication onCreate()");
        mContext = this;
        Fresco.initialize(this);
        LeakCanary.install(this);
        BlockCanary.install(this, new AppContext()).start();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.d("Vincent", "onActivityCreate callback =" + activity.getLocalClassName() + "  time = "
                        + System.currentTimeMillis());
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    @Override
    public void onTerminate() {
        Log.d("Vincent", "DemoApplication onTerminate()");
        super.onTerminate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        Variable.appStartTime = System.currentTimeMillis();
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Application getContext() {
        return mContext;
    }

    //参数设置
    public class AppContext extends BlockCanaryContext {
        private static final String TAG = "AppContext";

        @Override
        public String provideQualifier() {
            String qualifier = "";
            try {
                PackageInfo info = DemoApplication.getContext().getPackageManager()
                        .getPackageInfo(DemoApplication.getContext().getPackageName(), 0);
                qualifier += info.versionCode + "_" + info.versionName + "_YYB";
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(TAG, "provideQualifier exception", e);
            }
            return qualifier;
        }

        @Override
        public int provideBlockThreshold() {
            return 100;
        }

        @Override
        public boolean displayNotification() {
            return BuildConfig.DEBUG;
        }

        @Override
        public boolean stopWhenDebugging() {
            return false;
        }
    }
}
