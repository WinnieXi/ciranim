package com.wn.ciranim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.nineoldandroids.view.ViewHelper;
import com.wn.ciranim.view.CirRoundDebugView;

import ciranim.wn.library.util.Utils;

/**
 * 模拟地球绕太阳自转，
 * desc：模仿地球自转，
 */
public class CirRoundActivity extends AppCompatActivity {

    ImageView imgBlue;
    CirRoundDebugView mCirDebug;

    AnimatorSet animatorSet;
    float mRadius = 400;
    PointF mCenter = new PointF(600, 800);
    private float mValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cir_round);

        imgBlue = (ImageView) findViewById(R.id.transition_blue);
        mCirDebug = (CirRoundDebugView) findViewById(R.id.v_cirdebug);
        initData();
    }

    public void initData() {

        mCirDebug.drawDebugView(mRadius, mCenter);

        ObjectAnimator oa = ObjectAnimator.ofFloat(this, "degree", 0, 360);
        oa.setDuration(14000);
        oa.setRepeatCount(-1);
        oa.setInterpolator(new LinearInterpolator());

        ObjectAnimator anim = ObjectAnimator.ofFloat(imgBlue, "rotation", 0f, 360f);
        anim.setDuration(2000);
        anim.setRepeatCount(-1);
        anim.setRepeatMode(ObjectAnimator.RESTART);
        anim.setInterpolator(new LinearInterpolator());
        animatorSet = new AnimatorSet();
        animatorSet.play(oa).with(anim);
        animatorSet.start();
    }

    float getDegree() {
        return mValue;
    }

    void setDegree(float degree) {
        mValue = degree;
        float x = mCenter.x + mRadius
                * Utils.cos(degree);
        float y = mCenter.y - mRadius
                * Utils.sin(degree);
        ViewHelper.setX(imgBlue, x - 50);
        ViewHelper.setY(imgBlue, y - 50);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (animatorSet != null)
            animatorSet.cancel();
    }
}
