package com.happy.happyproject.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.happy.happyproject.R;

/**
 * Created by Administrator on 2016/9/21.
 */
public class CartFragment extends BaseFragment implements View.OnClickListener {
    private ImageView mGoBack;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.cart_fragment,container,false);
        return layout;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mGoBack = ((ImageView) layout.findViewById(R.id.currency_bar_goback));
        mGoBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.currency_bar_goback:
                getActivity().finish();
                break;
        }
    }
}
