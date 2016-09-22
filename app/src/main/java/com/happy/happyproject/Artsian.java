package com.happy.happyproject;

import android.app.Application;



import org.xutils.x;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class Artsian extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);

    }
}
