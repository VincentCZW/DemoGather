package com.example.annotation_tool.demogather.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.annotation_tool.demogather.R;

/**
 * Created by Vincent on 2018/1/8.
 */

public class ClipRectView extends View {


    private Paint paint;
    private Bitmap[] imgs = new Bitmap[3];

    public ClipRectView(Context context) {
        this(context, null, 0);
    }

    public ClipRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        imgs[0] = BitmapFactory.decodeResource(getResources(), R.drawable.test_1);
        imgs[1] = BitmapFactory.decodeResource(getResources(), R.drawable.test_2);
        imgs[2] = BitmapFactory.decodeResource(getResources(), R.drawable.test_3);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < imgs.length; ++i) {
            canvas.save();
            if (i != imgs.length -1) {
                canvas.clipRect(i * 40, 0, (i + 1) * 40, imgs[i].getHeight());
            } else {
                canvas.clipRect(i * 40, 0, i * 40 + imgs[i].getWidth(), imgs[i].getHeight() );
            }
            canvas.drawBitmap(imgs[i], i * 40, 0, paint);
            canvas.restore();
        }
    }
}