package com.happy.happyproject.ui.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.happy.happyproject.R;
import com.happy.happyproject.ui.SpaceFloatBtnActivity;
import com.rock.qrcodelibrary.CaptureActivity;

public class TopBar extends RelativeLayout implements View.OnClickListener {
    private static final String TAG = TopBar.class.getSimpleName();
    private ImageView mScan;
    private TextView mSearch;
    private TextView mDesigne;


    public TopBar(Context context) {
        this(context,null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.topbar, this,true);
        mDesigne = ((TextView) view.findViewById(R.id.tobar_image));
        mScan = ((ImageView) view.findViewById(R.id.topbar_scan));
        mSearch = ((TextView) view.findViewById(R.id.topbar_search));
        mScan.setOnClickListener(this);
        mSearch.setOnClickListener(this);
        mDesigne.setOnClickListener(this);
}


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.topbar_search:
//                Log.e(TAG, "onClick: search" );
//                Toast.makeText(getContext(), "此功能暂时没有开放", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.topbar_scan:
                //Toast.makeText(getContext(), "此功能暂时没有开放", Toast.LENGTH_SHORT).show();
                // 启动扫描页面
                Intent intent1 = new Intent(getContext(), CaptureActivity.class);
//                getContext().startActivityForResult(intent,QR_REQUEST_CODE);
                getContext().startActivity(intent1 );
                break;
            case R.id.tobar_image:
                Intent intent = new Intent(getContext(), SpaceFloatBtnActivity.class);
                getContext().startActivity(intent);
                break;
        }
    }
}
