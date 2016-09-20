package com.happy.happyproject.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.happy.happyproject.R;
import com.happy.happyproject.adapters.SmithyRecyclerAdapter;
import com.happy.happyproject.http.SmithyNavigationRequest;
import com.happy.happyproject.http.SmithyTopRequest;
import com.happy.happyproject.model.SmithyNavigation;
import com.happy.happyproject.model.SmithyNavigationList;
import com.happy.happyproject.model.SmithyTopView;
import com.happy.happyproject.model.SmithyTopViewList;
import com.qf.bannder.Banner;
import com.qf.bannder.BannerConfig;

import org.xutils.common.Callback;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */
public class SmithyFragment extends BaseFragment {
    public static final String TAG = SmithyFragment.class.getSimpleName();
    private static final int BANNER_DELAY_TIEM = 3 * 1000;
    private Banner mBanner;
    private List<String> images;
    private RecyclerView mRecyclerView;
    private SmithyRecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout=inflater.inflate(R.layout.smithyfragment,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setupView();
    }



    private void initView() {
        images = new ArrayList<>();
        mBanner = ((Banner) layout.findViewById(R.id.smithy_fragment_banner));
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        mBanner.setDelayTime(BANNER_DELAY_TIEM);

        mRecyclerView = ((RecyclerView) layout.findViewById(R.id.smithy_fragment_recycler));
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new SmithyRecyclerAdapter(getContext(),null);
        mRecyclerView.setAdapter(mAdapter);
    }


    private void setupView() {
        setupTopView();
        setupNavigation();

    }



    /**
     * 加载头部图片轮播
     *
     */
    private void setupTopView() {
        SmithyTopRequest request = new SmithyTopRequest();
        request.page="1";
        x.http().get(request, new Callback.CommonCallback<SmithyTopViewList>() {
            @Override
            public void onSuccess(SmithyTopViewList result) {
                Log.e(TAG, "setupTopView onSuccess: " );

                for (SmithyTopView smithy : result.getHeadlines()) {
                    images.add(smithy.getThumb());
                }

                mBanner.setImages(images);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "setupTopView onError: "+ ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "setupTopView onCancelled: " );
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "setupTopView onFinished: " );
            }
        });
    }

    /**
     * 加载中间导航
     *
     */
    private void setupNavigation() {
        SmithyNavigationRequest request = new SmithyNavigationRequest();
        x.http().get(request, new Callback.CommonCallback<SmithyNavigationList>() {
            @Override
            public void onSuccess(SmithyNavigationList result) {
                Log.e(TAG, "setupNavigation onSuccess: 中间导航" );
                List<SmithyNavigation> data = new ArrayList<>();
                for (int i = result.getCategories().size()-1; i >= 0; i--) {
                    data.add(result.getCategories().get(i));
                }
                mAdapter.addRes(data);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "setupNavigation onError: " +ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "setupNavigation onCancelled: " );
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "setupNavigation onFinished: " );
            }
        });
    }
}
