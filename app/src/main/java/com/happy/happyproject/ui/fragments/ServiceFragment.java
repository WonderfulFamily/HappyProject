package com.happy.happyproject.ui.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.happy.happyproject.R;
import com.happy.happyproject.myview.MineTopBar;
import com.happy.happyproject.ui.MineJumpActivity;

/**
 * Created by Administrator on 2016/9/20.
 */
public class ServiceFragment extends BaseFragment implements View.OnClickListener {
    private View mRelative;
    private PopupWindow popupWindow;
    private TextView mCancel;
    private TextView mCall;
    private View pop;
    private TextView mOnline;
    private MineTopBar mMineTopBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.service_fragment, container, false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMineTopBar = ((MineTopBar) layout.findViewById(R.id.mine_mineTopBar));
        mMineTopBar.setTitle("联系客服");
        mMineTopBar.initBack(getActivity());

        mRelative = layout.findViewById(R.id.service_pop_relative);
        mRelative.setOnClickListener(this);
        mOnline = ((TextView) layout.findViewById(R.id.mine_service_online));
        mOnline.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.service_pop_relative:
                showPop();
                break;
            case R.id.service_pop_cancel:
                popupWindow.dismiss();
                backgroundAlpha(1f);
                break;
            case R.id.service_pop_confirm:
                CallPhoneServer();
                break;
            case R.id.mine_service_online:
                onLineServce();
                break;
        }
    }

    /**
     * 显示popWindow
     */
    private void showPop() {
        pop = LayoutInflater.from(getActivity()).inflate(R.layout.pop, null);
        initView();

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int heightPixels = displayMetrics.heightPixels;
        int widthPixels = displayMetrics.widthPixels;

        if (popupWindow == null) {
            // new 一个 并设置大小
            this.popupWindow = new PopupWindow(pop,widthPixels/2,heightPixels * 2/ 15);
//            popupWindow.setWidth(widthPixels / 2);
//            popupWindow.setHeight(heightPixels * 2/ 15);
        }
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();

        } else {
            popupWindow.showAtLocation(mRelative, Gravity.CENTER, 0, 0);
            backgroundAlpha(0.5f);
        }
        // 点击空白处，隐藏pop窗口
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.setFocusable(true);
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            /**
             * 当popupWindow销毁时 背景改回原色
             */
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    backgroundAlpha(1f);
                }
            });
        }
    }

    /**
     * 设置背景
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getActivity().getWindow().setAttributes(lp);
    }

    /**
     * popupWindow 设置实例化和点击事件
     */
    private void initView() {
        mCancel = ((TextView) pop.findViewById(R.id.service_pop_cancel));
        mCall = ((TextView) pop.findViewById(R.id.service_pop_confirm));
        mCancel.setOnClickListener(this);
        mCall.setOnClickListener(this);
    }

    /**
     * PopupWindow 点击确定时 拨打电话
     */
    private void CallPhoneServer() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("tel:4006710747"));
        startActivity(intent);
    }

    /**
     * 在线联系客服
     */
    private void onLineServce() {
        Intent intent = new Intent(getActivity(), MineJumpActivity.class);
        intent.putExtra("service","留言");
        startActivity(intent);
    }
}
