package com.happy.happyproject.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.happy.happyproject.R;

public class DesignerActivity extends BaseActivity {

    private static final String URL ="https://www.jiangwoo.com/designers/join_us.html" ;
    private static final String TAG = DesignerActivity.class.getSimpleName();
    private WebView mWebView;
    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer);
        initView();
    }

    private void initView() {
        mProgress = (ProgressBar) findViewById(R.id.designer_progress);
        mWebView = (WebView) findViewById(R.id.designersWebView);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        WebViewClient client = new WebViewClient();
        mWebView.setWebViewClient(client);
        mWebView.setWebChromeClient(chromeClient);
        mWebView.loadUrl(URL);

    }
    private WebChromeClient chromeClient = new WebChromeClient(){
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            Log.e(TAG, "onProgressChanged: "+newProgress );
            mProgress.setProgress(newProgress);
            if (newProgress == 100) {
                mProgress.setVisibility(View.GONE);
            }else{
                mProgress.setVisibility(View.VISIBLE);
            }
        }
    };
}
