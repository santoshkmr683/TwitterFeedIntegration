package com.twitter.feed.integration.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import com.twitter.feed.integration.BuildConfig;
import com.twitter.feed.integration.R;
import com.twitter.feed.integration.util.Constant;
import com.twitter.feed.integration.util.DialogUtil;

public class WebViewActivity extends AppCompatActivity {

    private String mUrl;
    private WebView mWebView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        getDataFromBundle();
        initView();
    }

    private void initView() {
        mWebView = findViewById(R.id.web_view);
        mProgressBar = findViewById(R.id.progressBar);
        ImageView closeBtn = findViewById(R.id.close_btn);
        setupWebViewAndLoadUrl();
        closeBtn.setOnClickListener(v -> finish());
    }

    private void getDataFromBundle() {
        mUrl = getIntent().getStringExtra(Constant.KEY_URL);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupWebViewAndLoadUrl() {

        WebViewClient webViewClient = new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                //handler.proceed(); // Ignore SSL certificate errors
                DialogUtil.showWebViewSslErrorDialog(WebViewActivity.this, handler);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

        };
        mWebView.setWebChromeClient(new WebChromeClient() {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onPermissionRequest(final PermissionRequest request) {
                request.grant(request.getResources());
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                mProgressBar.setVisibility(View.VISIBLE);
                mProgressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.INVISIBLE);
                }
            }
        });

        WebSettings settings = mWebView.getSettings();
        mWebView.setWebViewClient(webViewClient);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        if (BuildConfig.DEBUG) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (mUrl != null) {
            mWebView.loadUrl(mUrl);
        }
    }

    @Override
    public void onBackPressed() {

        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
