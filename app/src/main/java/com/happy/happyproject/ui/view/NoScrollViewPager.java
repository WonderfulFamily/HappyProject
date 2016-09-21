package com.happy.happyproject.ui.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 不可滚动的ViewPager
 * Created by Administrator on 2016/9/21 0021.
 *
 */
public class NoScrollViewPager extends ViewPager {
    private boolean isCanScroll = true;
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
        if (isCanScroll) {
            return true;
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
        if (isCanScroll) {
            return true;
        }
        return super.onTouchEvent(ev);
    }
}
