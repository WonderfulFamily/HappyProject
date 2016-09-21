package com.happy.happyproject.ui.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/9/6.
 */
public class BottomBehavior extends CoordinatorLayout.Behavior<View>{
    public BottomBehavior() {
    }

    public BottomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 如果我们想要关注嵌套滑动事件，我们需要在这返回true
     * @return
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    /**
     *
     * 在嵌套的滚动View准备滑动时调用
     */
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if (dy>0) {
            ViewCompat.animate(child).translationY(0).start();

        }else {

            ViewCompat.animate(child).translationY(child.getHeight()).start();
        }
    }
}
