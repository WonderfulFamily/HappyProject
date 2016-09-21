package com.happy.happyproject.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.happy.happyproject.R;
import com.happy.happyproject.myview.CurrencyBar;

/**
 * Created by Administrator on 2016/9/21.
 */
public class LiuYanFragment extends BaseFragment {
    private CurrencyBar mBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.liuyan_fragment,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBar = ((CurrencyBar) layout.findViewById(R.id.liuyan_currencyBar));
        mBar.setTitle("留言");
        mBar.initBack(getActivity());
    }
}
