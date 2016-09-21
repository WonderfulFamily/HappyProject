package com.happy.happyproject.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.happy.happyproject.R;
import com.happy.happyproject.myview.MineTopBar;

/**
 * Created by Administrator on 2016/9/21.
 */
public class MineOrderFragment extends BaseFragment {
    private MineTopBar mTopBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.mine_order_fragment,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTopBar = ((MineTopBar) layout.findViewById(R.id.mine_order_topbar));
        mTopBar.setTitle("商品订单");
        mTopBar.initBack(getActivity());
    }
}
