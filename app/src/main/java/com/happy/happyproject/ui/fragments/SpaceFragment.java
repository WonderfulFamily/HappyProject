package com.happy.happyproject.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.happy.happyproject.R;
import com.happy.happyproject.adapter.SpaceAdapter;
import com.happy.happyproject.http.SpaceRequest;
import com.happy.happyproject.model.SpaceList;
import com.happy.happyproject.ui.SpaceJumpActivity;

import org.xutils.common.Callback;
import org.xutils.x;

/**
 * Created by Administrator on 2016/9/20.
 */
public class SpaceFragment extends BaseFragment implements SpaceAdapter.OnItemClickListener {
    public static final String TAG = SpaceFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private  SpaceAdapter adapter;

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
         adapter = new SpaceAdapter(getActivity(), null);
        adapter.setListener(this);
        mRecyclerView.setAdapter(adapter);
    }
    private void setupView() {
        final  SpaceRequest request = new SpaceRequest();
        x.http().get(request, new Callback.CommonCallback<SpaceList>() {
            @Override
            public void onSuccess(SpaceList result) {
                Log.e(TAG, "onSuccess: =====");
                adapter.updataRes(result.getSpaces());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: " );
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled: " );
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished: " );
            }
        });

    }

    @Override
    public void onItemClick(int position, View v) {
        Log.e(TAG, "onItemClick: "+position );
        switch (v.getId()) {
            case R.id.space_recyclerview_image:
                Intent intent = new Intent(getActivity(), SpaceJumpActivity.class);
                startActivity(intent);
                break;
        }
    }
}
