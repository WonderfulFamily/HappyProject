package com.happy.happyproject.myview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.happy.happyproject.R;


/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class MineTopBar extends RelativeLayout implements View.OnClickListener {
    private static final String TAG = MineTopBar.class.getSimpleName();
    private ImageView mBlackBack;
    private TextView mTitle;
    private Activity mActivity;

    public MineTopBar(Context context) {
        this(context,null);
    }

    public MineTopBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MineTopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.mtopbar, this, true);
        mBlackBack = ((ImageView) view.findViewById(R.id.currency_bar_left_black_image));
        mTitle = ((TextView) view.findViewById(R.id.currency_bar_black_title));
        mBlackBack.setOnClickListener(this);
        
    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title){
        mTitle.setText(title);

    }

    /**
     * 初始化返回
     * @param mActivity
     */
    public void initBack(Activity mActivity){
        this.mActivity = mActivity;
    }


    /**
     * 返回的点击监听
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.currency_bar_left_black_image:
                if (mActivity!=null) {
                    mActivity.finish();
                }else{
                    Log.e(TAG, "currentBar没有进行初始化" );
                }

                break;
        }
    }
}
