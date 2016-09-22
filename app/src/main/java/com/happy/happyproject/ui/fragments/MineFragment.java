package com.happy.happyproject.ui.fragments;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.happy.happyproject.R;
import com.happy.happyproject.ui.DesignerActivity;
import com.happy.happyproject.ui.MineJumpActivity;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Set;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by Administrator on 2016/9/20.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener, PlatformActionListener,Handler.Callback {
    public static final String TAG = MineFragment.class.getSimpleName();
    private View mDesignersIn;
    private View mService;
    private View mOrders;
    private View mMessage;
    private View mSpaceLike;
    private View mProductsLike;
    private ImageView mCart;
    private ImageView mSetting;
    private ImageView mLogin;

    private Handler mHandler = new Handler(this);
    private TextView mName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout=inflater.inflate(R.layout.minefragment,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFindView();
        initSetListener();
    }
    private void initFindView() {
        mCart = ((ImageView) layout.findViewById(R.id.currency_bar_left_cart_image));
        mSetting = ((ImageView) layout.findViewById(R.id.currency_bar_right_setting_iamge));
        mDesignersIn = layout.findViewById(R.id.mine_designers_in);
        mMessage = layout.findViewById(R.id.mine_message);
        mService = layout.findViewById(R.id.mine_service);
        mOrders = layout.findViewById(R.id.mine_orders);
        mSpaceLike = layout.findViewById(R.id.mine_space_like);
        mProductsLike = layout.findViewById(R.id.mine_products_liked);
        mLogin = ((ImageView) layout.findViewById(R.id.mine_logo_image));
        mName = ((TextView) layout.findViewById(R.id.mine_text_name));
    }
    private void initSetListener() {
        // 设计师入驻
        mDesignersIn.setOnClickListener(this);
        mService.setOnClickListener(this);
        mOrders.setOnClickListener(this);
        mMessage.setOnClickListener(this);
        mSpaceLike.setOnClickListener(this);
        mProductsLike.setOnClickListener(this);
        mCart.setOnClickListener(this);
        mSetting.setOnClickListener(this);
        mLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), MineJumpActivity.class);
        switch (v.getId()) {
            case R.id.mine_orders:
                intent.putExtra("service","商品订单");
                startActivity(intent);
                break;
            case R.id.mine_space_like:
                intent.putExtra("service","喜欢的空间");
                startActivity(intent);
                break;
            case R.id.mine_products_liked:
                intent.putExtra("service","喜欢的商品");
                startActivity(intent);
                break;
            case R.id.mine_message:
                intent.putExtra("service","我的消息");
                startActivity(intent);
                break;
            case R.id.mine_service:
                intent.putExtra("service","联系客服");
                startActivity(intent);
                break;
            case R.id.mine_designers_in:
                DesignersIn();
                break;
            case R.id.currency_bar_left_cart_image:
                intent.putExtra("service","购物车");
                startActivity(intent);
                break;
            case R.id.currency_bar_right_setting_iamge:
                intent.putExtra("service","设置");
                startActivity(intent);
                break;
            case R.id.mine_logo_image:

                // 调用平台初始化
                ShareSDK.initSDK(getActivity());
                // 获取平台
                Platform platform = ShareSDK.getPlatform(getActivity(), QQ.NAME);
                // 设置监听
                platform.setPlatformActionListener(this);
                // 调用授权
                platform.authorize();
                // 显示用户信息
                platform.showUser(null);


                break;

        }
    }
    /**
     * 设计师注入
     */
    private void DesignersIn() {
        Intent intent = new Intent(getActivity(), DesignerActivity.class);
        startActivity(intent);
    }



    private void showShare(String title,String titleUrl) {
        ShareSDK.initSDK(getActivity());
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(title);
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl(titleUrl);
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");
        // 启动分享GUI
        oks.show(getActivity());
    }



    //--------------------------------  ------------------------------------------------
    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            Object value = hashMap.get(key);
            Log.e(TAG, "onComplete: key:" + key + "<<<-value:" + value);
        }
        Message obtain = Message.obtain();
        obtain.obj = hashMap;
        mHandler.sendMessage(obtain);

    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {

    }

    @Override
    public void onCancel(Platform platform, int i) {

    }

    @Override
    public boolean handleMessage(Message msg) {
        HashMap hashMap = (HashMap) msg.obj;
        Object nickname = hashMap.get("nickname");
        Object figureurl2 = hashMap.get("figureurl_2");
        mName.setText(nickname.toString());
        Picasso.with(getActivity()).load(figureurl2.toString()).into(mLogin);
        return false;
    }
}
