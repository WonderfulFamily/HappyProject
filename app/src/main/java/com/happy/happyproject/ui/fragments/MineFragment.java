package com.happy.happyproject.ui.fragments;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.happy.happyproject.R;
import com.happy.happyproject.ui.DesignerActivity;
import com.happy.happyproject.ui.MineJumpActivity;

/**
 * Created by Administrator on 2016/9/20.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener{
    public static final String TAG = MineFragment.class.getSimpleName();
    private View mDesignersIn;
    private View mService;
    private View mOrders;
    private View mMessage;
    private View mSpaceLike;
    private View mProductsLike;
    private ImageView mCart;
    private ImageView mSetting;
    private ImageView mLogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout=inflater.inflate(R.layout.minefragment,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFindView();
        initSetListener();
    }
    private void initFindView() {
        mCart = ((ImageView) layout.findViewById(R.id.currency_bar_left_cart_image));
        mSetting = ((ImageView) layout.findViewById(R.id.currency_bar_right_setting_iamge));
        mDesignersIn = layout.findViewById(R.id.mine_designers_in);
        mMessage = layout.findViewById(R.id.mine_message);
        mService = layout.findViewById(R.id.mine_service);
        mOrders = layout.findViewById(R.id.mine_orders);
        mSpaceLike = layout.findViewById(R.id.mine_space_like);
        mProductsLike = layout.findViewById(R.id.mine_products_liked);
        mLogin = ((ImageView) layout.findViewById(R.id.mine_logo_image));
    }
    private void initSetListener() {
        // 设计师入驻
        mDesignersIn.setOnClickListener(this);
        mService.setOnClickListener(this);
        mOrders.setOnClickListener(this);
        mMessage.setOnClickListener(this);
        mSpaceLike.setOnClickListener(this);
        mProductsLike.setOnClickListener(this);
        mCart.setOnClickListener(this);
        mSetting.setOnClickListener(this);
        mLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), MineJumpActivity.class);
        switch (v.getId()) {
            case R.id.mine_orders:
                intent.putExtra("service","商品订单");
                startActivity(intent);
                break;
            case R.id.mine_space_like:
                intent.putExtra("service","喜欢的空间");
                startActivity(intent);
                break;
            case R.id.mine_products_liked:
                intent.putExtra("service","喜欢的商品");
                startActivity(intent);
                break;
            case R.id.mine_message:
                intent.putExtra("service","我的消息");
                startActivity(intent);
                break;
            case R.id.mine_service:
                intent.putExtra("service","联系客服");
                startActivity(intent);
                break;
            case R.id.mine_designers_in:
                DesignersIn();
                break;
            case R.id.currency_bar_left_cart_image:
                intent.putExtra("service","购物车");
                startActivity(intent);
                break;
            case R.id.currency_bar_right_setting_iamge:
                intent.putExtra("service","设置");
                startActivity(intent);
                break;
            case R.id.mine_logo_image:

                break;

        }
    }
    /**
     * 设计师注入
     */
    private void DesignersIn() {
        Intent intent = new Intent(getActivity(), DesignerActivity.class);
        startActivity(intent);
    }

}
