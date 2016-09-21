package com.happy.happyproject.ui.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.happy.happyproject.R;
import com.happy.happyproject.ui.BaseActivity;

public class SpaceFloatBtnActivity extends BaseActivity implements View.OnClickListener {

    private android.widget.ImageView teachcancel;
    private android.widget.ImageView teachdinner;
    private android.widget.ImageView teachoffice;
    private android.widget.ImageView teachart;
    private android.widget.ImageView teachhotel;
    private android.widget.ImageView teachlife;
    private android.widget.ImageView teachpublic;
    private android.widget.ImageView teachretail;
    private android.widget.ImageView teachother;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_float_btn);
        initView();
    }

    private void initView() {
        this.teachother = (ImageView) findViewById(R.id.teach_other);
        this.teachretail = (ImageView) findViewById(R.id.teach_retail);
        this.teachpublic = (ImageView) findViewById(R.id.teach_public);
        this.teachlife = (ImageView) findViewById(R.id.teach_life);
        this.teachhotel = (ImageView) findViewById(R.id.teach_hotel);
        this.teachart = (ImageView) findViewById(R.id.teach_art);
        this.teachoffice = (ImageView) findViewById(R.id.teach_office);
        this.teachdinner = (ImageView) findViewById(R.id.teach_dinner);
        this.teachcancel = (ImageView) findViewById(R.id.teach_cancel);

        teachother.setOnClickListener(this);
        teachretail.setOnClickListener(this);
        teachpublic.setOnClickListener(this);
        teachlife.setOnClickListener(this);
        teachhotel.setOnClickListener(this);
        teachart.setOnClickListener(this);
        teachoffice.setOnClickListener(this);
        teachdinner.setOnClickListener(this);
        teachcancel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.teach_other:
                Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.teach_retail:
                Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.teach_public:
                Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.teach_life:
                Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.teach_hotel:
                Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.teach_art:
                Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.teach_office:
                Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.teach_dinner:
                Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.teach_cancel:
                Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
