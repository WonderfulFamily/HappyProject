package com.happy.happyproject.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.happy.happyproject.R;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class SmithyDesignFragment extends BaseFragment {

    private static final String TAG = SmithyDesignFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_design,container,false);
        return  layout;
    }

}