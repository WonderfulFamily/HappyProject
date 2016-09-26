package com.happy.happyproject.ui.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * 不可滚动的ViewPager
 * Created by Administrator on 2016/9/21 0021.
 *
 */
public class NoScrollViewPager extends ViewPager {
    private static final String TAG = NoScrollViewPager.class.getSimpleName();
    private boolean isCanScroll = true;
    private float mStartX;
    private float mStartY;
    private float mLastX;
    private float mLastY;

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCanScroll (boolean isCanScroll){
        this.isCanScroll = isCanScroll;
    }

    /**
     * 进行事件的拦截
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        float x = ev.getX();
        float y = ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartX = x;
                mStartY = y;
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                if (isCanScroll) {
                    float  xDelta = x-mLastX;
                    float yDelta = x - mLastY;
                    if (Math.abs(xDelta)>Math.abs(yDelta)) {
                        return true;
                    }
                }
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    /**
     * 事件消费
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        float x = ev.getX();
        float y = ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartX = x;
                mStartY = y;
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                if (isCanScroll) {
                    float  xDelta = x-mLastX;
                    float yDelta = x - mLastY;
                    if (Math.abs(xDelta)>Math.abs(yDelta)) {
                        Log.e(TAG, "onTouchEvent: "+xDelta+":::"+yDelta );
                        return true;
                    }
                }
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:

                break;
        }



        return super.onTouchEvent(ev);
    }
}
