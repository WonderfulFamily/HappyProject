package com.happy.happyproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.happy.happyproject.R;
import com.happy.happyproject.adapters.SpaceListViewAdapter;
import com.happy.happyproject.model.SpaceJump;
import com.happy.happyproject.model.SpaceJumpList;
import com.happy.happyproject.model.SpaceJumpModel;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;
import java.util.List;


public class SpaceJumpActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = SpaceJumpActivity.class.getSimpleName();
    private ImageView mImageHead;
    private TextView mName;
    private ListView mListView;
    private SpaceListViewAdapter adapter;
    private SpaceJumpList space;
    private String url;
   private String id;
    private String name;
    private TextView mNameTitle;
    private TextView mSpeak;
    private TextView mHeartNum;
    private TextView mShareNum;
    private FloatingActionButton mFloatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_jump);

        initView();
        setupView();
    }



    private void initView() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        Log.e(TAG, "initView:id----------------------- "+id );
        url = intent.getStringExtra("url");
        Log.e(TAG, "initView:-------------------------- "+url );
        name = intent.getStringExtra("name");
        Log.e(TAG, "initView: --------------------------"+name );
        mNameTitle = (TextView) findViewById(R.id.spacejump_name);
        mNameTitle.setText(name);
        mImageHead = (ImageView) findViewById(R.id.spacejump_image);
       x.image().bind(mImageHead,"http://" +url);
        mName = (TextView) findViewById(R.id.spacejump_name);
        mListView = (ListView) findViewById(R.id.spacejump_listview);
        adapter = new SpaceListViewAdapter(this,null);
        mListView.setAdapter(adapter);

        mSpeak = (TextView) findViewById(R.id.space_pinglu_num);
        mHeartNum = (TextView) findViewById(R.id.space_heart_num);
        mShareNum = (TextView) findViewById(R.id.space_shared_num);
        mFloatBtn = (FloatingActionButton) findViewById(R.id.space_float_btn);
        mFloatBtn.setOnClickListener(this);

    }
    private void setupView() {
        final RequestParams requestParams = new RequestParams("http://api.jiangwoo.com/api/v1/spaces/"+id+"?id="+id);
//        final SpaceJumpRequest request = new SpaceJumpRequest();
//        request.id= Integer.parseInt(id);
        x.http().get(requestParams, new Callback.CommonCallback<SpaceJumpModel>() {
            @Override
            public void onSuccess(SpaceJumpModel result) {
                Log.e(TAG, "onSuccess: re----------------------------------------" + requestParams);

                List<SpaceJump> data = result.getSpace().getSpace_items();
                mSpeak.setText(result.getSpace().getComments_count());
                mHeartNum.setText(result.getSpace().getFavs_count());
                mShareNum.setText(result.getSpace().getShares_count());
                adapter.updataRes(data);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: -------------------------------------------" +ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled: " );
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished: ");
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.space_float_btn:
                Intent intent = new Intent(this, SpaceFloatBtnActivity.class);
                startActivity(intent);
                break;

        }
    }
}
