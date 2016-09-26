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
import com.happy.happyproject.adapters.DesignAdapter;
import com.happy.happyproject.http.DesignRequest;
import com.happy.happyproject.model.ProductsList;

import org.xutils.common.Callback;
import org.xutils.x;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class SmithySelectorFragment extends BaseFragment {

    private static final String TAG = SmithySelectorFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private DesignAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_selection,container,false);
        return  layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setupView();

    }

    private void initView() {
        mRecyclerView = (RecyclerView)layout.findViewById(R.id.select_recycler);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new DesignAdapter(getContext(),null);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void setupView() {
        DesignRequest entity = new DesignRequest();
        entity.page="1";
        entity.source="external";
        x.http().get(entity, new Callback.CommonCallback<ProductsList>() {
            @Override
            public void onSuccess(ProductsList result) {
                Log.e(TAG, "onSuccess: " );
                mAdapter.addRes(result.getProducts());
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

}
