package com.yiyi.zhihu.ui.editor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.webkit.WebView;

import com.yiyi.zhihu.BuildConfig;
import com.yiyi.zhihu.R;
import com.yiyi.zhihu.common.BaseActivity;
import com.yiyi.zhihu.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditorDetailActivity extends BaseActivity {

    private static final String TAG = "EditorDetailActivity";

    @BindView(R.id.toolBar)
    Toolbar mToolbar;
    @BindView(R.id.webview)
    WebView mWebView;

    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_detail);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("editorId", 0);
        url = "";
        if (id != 0) {
            url = BuildConfig.API_BASE_URL + "editor/" + id + "/profile-page/android";
        } else {
            Log.e(TAG, "请求失败，主编ID为空");
        }
    }

    @Override
    public void initView() {
        setToolbar(mToolbar, "主编资料");
        initWebViewClient();
    }

    private void initWebViewClient() {
        mWebView.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    public void initLoad() {
        mWebView.loadUrl(url);
    }
}
