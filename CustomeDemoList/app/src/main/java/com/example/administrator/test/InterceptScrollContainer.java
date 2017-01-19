package com.example.administrator.test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/1/18.
 */

public class InterceptScrollContainer extends LinearLayout{

    public InterceptScrollContainer(Context context) {
        super(context);
    }

    public InterceptScrollContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InterceptScrollContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("onInterceptTouchEvent", "onInterceptTouchEvent");
        return true;
    }
}
