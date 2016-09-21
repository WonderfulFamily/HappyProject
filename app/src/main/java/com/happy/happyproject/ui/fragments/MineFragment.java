package com.happy.happyproject.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        mDesignersIn = layout.findViewById(R.id.mine_designers_in);
        mService = layout.findViewById(R.id.mine_service);
    }
    private void initSetListener() {
        // 设计师入驻
        mDesignersIn.setOnClickListener(this);
        mService.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), MineJumpActivity.class);
        switch (v.getId()) {
            case R.id.mine_service:
                intent.putExtra("service","联系客服");
                startActivity(intent);
                break;
            case R.id.mine_designers_in:
                DesignersIn();
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
