package com.happy.happyproject.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.happy.happyproject.R;
import com.happy.happyproject.http.SmithyTopRequest;
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
    }


    private void setupView() {
        SmithyTopRequest request = new SmithyTopRequest();
        request.page="1";
        x.http().get(request, new Callback.CommonCallback<SmithyTopViewList>() {
            @Override
            public void onSuccess(SmithyTopViewList result) {
                Log.e(TAG, "onSuccess: " );

                for (SmithyTopView smithy : result.getHeadlines()) {
                    images.add(smithy.getUrl());
                    Log.e(TAG, "onSuccess: "+smithy.getThumb() );
                }
                mBanner.setImages(images);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: "+ ex.getMessage());
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
}
