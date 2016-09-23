package com.happy.happyproject.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.happy.happyproject.R;

public class SpaceJumpSquareActivity extends AppCompatActivity implements View.OnClickListener {

    private android.widget.ImageView teachspaceback;
    private android.widget.ImageView teachspacecancel;
    private PopupWindow mpopupwindow;
    private View mPop;
    private Button mSure;
    private Button mUnsure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_jump_square);
        this.teachspacecancel = (ImageView) findViewById(R.id.teach_space_cancel);
        this.teachspaceback = (ImageView) findViewById(R.id.teach_space_back);
        initView();
    }

    private void initView() {
        this.teachspacecancel = (ImageView) findViewById(R.id.teach_space_cancel);
        this.teachspaceback = (ImageView) findViewById(R.id.teach_space_back);
        teachspaceback.setOnClickListener(this);
        teachspacecancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.teach_space_cancel:
            finish();
                break;
            case R.id.teach_space_back:
                finish();
                break;

        }
    }
}
