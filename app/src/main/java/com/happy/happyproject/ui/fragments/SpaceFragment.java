package com.happy.happyproject.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.happy.happyproject.R;
import com.happy.happyproject.adapter.SpaceAdapter;

/**
 * Created by Administrator on 2016/9/20.
 */
public class SpaceFragment extends BaseFragment {
    public static final String TAG = SpaceFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout=inflater.inflate(R.layout.spacefragment,container,false);
        initView();
        setupView();
        return layout;
    }



    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView = ((RecyclerView) layout.findViewById(R.id.space_recyclerview));
        mRecyclerView.setLayoutManager(layoutManager);
        SpaceAdapter adapter = new SpaceAdapter(getActivity(), null);
        mRecyclerView.setAdapter(adapter);
    }
    private void setupView() {

    }
}
