package com.weixiaokang.myview.scrollview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;


public class ScrollView extends View {

    private static final String TAG = "debug";
    private static final boolean DEBUG = true;
    private int width, height;
    private Paint paint;
    private Rect rect;

    public ScrollView(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }
    public ScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            if (DEBUG) { Log.i(TAG, "exactly"); }
            width = specSize;
        } else {
            
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawRect(0, 0, width, height - 200, paint);
    }

}
