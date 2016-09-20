package com.happy.happyproject.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.happy.happyproject.R;
import com.happy.happyproject.ui.fragments.MineFragment;
import com.happy.happyproject.ui.fragments.SmithyFragment;
import com.happy.happyproject.ui.fragments.SpaceFragment;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private android.widget.FrameLayout maincontainer;
    private android.widget.RadioButton maincontrollerhome;
    private android.widget.RadioButton maincontrollermatch;
    private android.widget.RadioButton maincontrollerfollow;
    private android.widget.RadioGroup maincontroller;
    private Fragment mShowFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        this.maincontroller = (RadioGroup) findViewById(R.id.main_controller);
        this.maincontrollerfollow = (RadioButton) findViewById(R.id.main_controller_follow);
        this.maincontrollermatch = (RadioButton) findViewById(R.id.main_controller_match);
        this.maincontrollerhome = (RadioButton) findViewById(R.id.main_controller_home);
        this.maincontainer = (FrameLayout) findViewById(R.id.main_container);

        maincontroller.setOnCheckedChangeListener(this);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mShowFragment = new SmithyFragment();
        transaction.add(R.id.main_container, mShowFragment,SmithyFragment.TAG);
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_controller_home:
                switchPages(SmithyFragment.TAG,SmithyFragment.class);
                break;
            case R.id.main_controller_match:
                switchPages(SpaceFragment.TAG,SpaceFragment.class);
                break;
            case R.id.main_controller_follow:
                switchPages(MineFragment.TAG,MineFragment.class);
                break;

        }
    }
    private void switchPages(String tag,Class<? extends Fragment> cls) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.hide(mShowFragment);
        mShowFragment = fm.findFragmentByTag(tag);
        if (mShowFragment!=null) {
            transaction.show(mShowFragment);
        }else{
            try {
                mShowFragment = cls.getConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            transaction.add(R.id.main_container,mShowFragment,tag);
        }
        transaction.commit();
    }
}
