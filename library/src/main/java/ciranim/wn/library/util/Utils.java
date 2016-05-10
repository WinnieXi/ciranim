package ciranim.wn.library.util;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class Utils {

    public static float sin(double degree){
        return (float) Math.sin(Math.toRadians(degree));
    }

    public static float cos(double degree){
        return (float) Math.cos(Math.toRadians(degree));
    }

    public static float asin(double value){
        return (float) Math.toDegrees(Math.asin(value));
    }

    public static float acos(double value){
        return (float) Math.toDegrees(Math.acos(value));
    }

    /**
     * 获取view 中心位置
     * @param view
     * @return
     */
    public static float centerX(View view){
        return ViewHelper.getX(view) + view.getWidth()/2;
    }

    public static float centerY(View view){
        return ViewHelper.getY(view) + view.getHeight()/2;
    }

}
