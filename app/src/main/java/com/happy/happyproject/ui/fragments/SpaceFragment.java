package com.happy.happyproject.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.happy.happyproject.R;
import com.happy.happyproject.adapter.SpaceAdapter;
import com.happy.happyproject.http.SpaceRequest;
import com.happy.happyproject.model.Space;
import com.happy.happyproject.model.SpaceList;
import com.happy.happyproject.ui.SpaceJumpActivity;

import org.xutils.common.Callback;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */
public class SpaceFragment extends BaseFragment implements SpaceAdapter.OnItemClickListener {
    public static final String TAG = SpaceFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private  SpaceAdapter adapter;
    private List<Space> list;
    private ImageView image;

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

                list = result.getSpaces();
                adapter.updataRes(list);
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
                //跳转页面
                Intent intent = new Intent(getActivity(), SpaceJumpActivity.class);

                String url = list.get(position).getThumb();
                intent.putExtra("url",adapter.getItem(position).getThumb());
                intent.putExtra("id",adapter.getItem(position).getId());
                intent.putExtra("name",adapter.getItem(position).getName());
//
////                image = (ImageView) v.findViewById(R.id.space_recyclerview_image);
////                Pair pair = new Pair(image,"teach");  ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),pair);
//
//                Log.e(TAG, "onItemClick: ==========================url"+adapter.getItem(position).getThumb());
//                Log.e(TAG, "onItemClick: ======id"+adapter.getItem(position).getId() );
////                intent.putExtra("thumb",url);
                startActivity(intent);
                break;
        }
    }
}
