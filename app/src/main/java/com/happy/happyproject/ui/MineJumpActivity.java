package com.happy.happyproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.happy.happyproject.R;
import com.happy.happyproject.ui.fragments.LiuYanFragment;
import com.happy.happyproject.ui.fragments.ServiceFragment;

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
        if (s.equals("联系客服")) {
            ServiceFragment fragment = new ServiceFragment();
            transaction.add(R.id.jump_frame, fragment);
        }else if (s.equals("留言")){
            LiuYanFragment fragment = new LiuYanFragment();
            transaction.add(R.id.jump_frame, fragment);
        }
    }
}
