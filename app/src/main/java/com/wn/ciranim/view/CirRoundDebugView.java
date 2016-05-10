package com.wn.ciranim.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by neusoft on 2016/5/9.
 */
public class CirRoundDebugView extends View {

    PointF mCenter;
    float mRadius;
    private Paint mPaintStroke = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CirRoundDebugView(Context context) {
        this(context, null, 0);
    }

    public CirRoundDebugView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CirRoundDebugView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaintStroke.setStyle(Paint.Style.STROKE);
        mPaintStroke.setStrokeWidth(3);
        mPaintStroke.setColor(Color.BLUE);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CirRoundDebugView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCenter != null) {
            canvas.drawCircle(mCenter.x, mCenter.y, mRadius, mPaintStroke);
            mPaintStroke.setStrokeWidth(10);
            canvas.drawPoint(mCenter.x, mCenter.y, mPaintStroke);
        }

    }

    public void drawDebugView(float mRadius, PointF mCenter) {
        this.mRadius = mRadius;
        this.mCenter = mCenter;
        invalidate();
    }


}
