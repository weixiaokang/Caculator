package weixiaokang.caculator.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Button;

import weixiaokang.caculator.R;


public class CircleButton extends Button {

    private Paint paint;
    private int radius = 0;
    private static final String TAG = "debug";
    private static final boolean DEBUG = true;
    private float radiusScale;
    private int color;

    public CircleButton(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public CircleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleButton);
        radiusScale = typedArray.getFloat(R.styleable.CircleButton_radiusScale, 0.75f);
        color = typedArray.getColor(R.styleable.CircleButton_circleButtonColor, 0xffffffff);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(color);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius * radiusScale, paint);
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setRadius();
    }

    private void setRadius() {
        if (getWidth() < getHeight()) {
            radius = getWidth() / 2;
        } else {
            radius = getHeight() / 2;
        }
    }
}