package com.happy.happyproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.happy.happyproject.R;
import com.happy.happyproject.ui.fragments.CartFragment;
import com.happy.happyproject.ui.fragments.LiuYanFragment;
import com.happy.happyproject.ui.fragments.MineGoodsLikeFragment;
import com.happy.happyproject.ui.fragments.MineMessFragment;
import com.happy.happyproject.ui.fragments.MineOrderFragment;
import com.happy.happyproject.ui.fragments.MineSpaceLikeFragment;
import com.happy.happyproject.ui.fragments.ServiceFragment;
import com.happy.happyproject.ui.fragments.SettingFragment;

public class MineJumpActivity extends BaseActivity {
    private FragmentTransaction transaction;
    private String service;
    private String LianXi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_jump);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        service = intent.getStringExtra("service");
        setFragmentMethod();
    }

    private void setFragmentMethod() {
        FragmentManager fm = getSupportFragmentManager();
        transaction = fm.beginTransaction();

        setUpDifferentFrag(service);

        transaction.commit();
    }

    private void setUpDifferentFrag(String s) {
        switch (s) {
            case "联系客服":
                ServiceFragment fragment = new ServiceFragment();
                transaction.add(R.id.jump_frame, fragment);
                break;
            case "留言":
                 LiuYanFragment liuFragment = new LiuYanFragment();
                transaction.add(R.id.jump_frame, liuFragment);
                break;
            case "商品订单":
                MineOrderFragment orderFragment = new MineOrderFragment();
                transaction.add(R.id.jump_frame, orderFragment);
                break;
            case "我的消息":
                MineMessFragment messFragment = new MineMessFragment();
                transaction.add(R.id.jump_frame, messFragment);
                break;
            case "喜欢的空间":
                MineSpaceLikeFragment spaceFragment = new MineSpaceLikeFragment();
                transaction.add(R.id.jump_frame, spaceFragment);
                break;
            case "喜欢的商品":
                MineGoodsLikeFragment goodFragment = new MineGoodsLikeFragment();
                transaction.add(R.id.jump_frame, goodFragment);
                break;
            case "购物车":
                CartFragment cartFragment = new CartFragment();
                transaction.add(R.id.jump_frame, cartFragment);
                break;
            case "设置":
                SettingFragment settingFragment = new SettingFragment();
                transaction.add(R.id.jump_frame, settingFragment);
                break;
        }
    }
}
