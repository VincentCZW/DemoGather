package com.example.annotation_tool.demogather.diy_view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by VincentChen on 2017/4/11.
 */
public class ShortVideoProgressBar extends View {

    private Paint mBackgroundPaint;
    private Paint mProgressPaint;

    private int barWidth;
    private float currProgress;

    public ShortVideoProgressBar(Context context) {
        this(context, null, 0);
    }

    public ShortVideoProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShortVideoProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Rect rect = new Rect(0 ,0 , 500, 50);
        Rect rect1 = new Rect(0, 0, 100, 50);
        canvas.drawRect(rect, mBackgroundPaint);
        canvas.drawRect(rect1, mProgressPaint);
    }

    private void init() {
        mBackgroundPaint = new Paint();
        mBackgroundPaint.setStyle(Paint.Style.FILL);
        mBackgroundPaint.setColor(Color.parseColor("#20ffffff"));

        mProgressPaint = new Paint();
        mProgressPaint.setStyle(Paint.Style.FILL);
        mProgressPaint.setColor(Color.parseColor("#cdffffff"));
    }

    public void setCurrProgress(float progress) {
        currProgress = progress;
    }
}
