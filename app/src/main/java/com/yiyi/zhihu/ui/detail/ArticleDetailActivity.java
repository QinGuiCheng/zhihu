package com.yiyi.zhihu.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.yiyi.zhihu.R;
import com.yiyi.zhihu.entity.commonEntity.StoryContentEntity;
import com.yiyi.zhihu.entity.commonEntity.StoryExtraEntity;
import com.yiyi.zhihu.global.Constants;
import com.yiyi.zhihu.loader.GlideImageLoader;
import com.yiyi.zhihu.mvpframe.base.BaseFrameActivity;
import com.yiyi.zhihu.ui.widget.badgeView.ActionProviderView;
import com.yiyi.zhihu.util.HtmlUtil;
import com.yiyi.zhihu.util.NetUtils;
import com.yiyi.zhihu.util.SharePreferencesHelper;
import com.yiyi.zhihu.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleDetailActivity extends BaseFrameActivity<DetailPresenter, DetailModel> implements DetailContract.View {

    private static final String TAG = "ArticleDetailActivity";

    ActionProviderView commentProvider;
    ActionProviderView praiseProvider;

    @BindView(R.id.toolBar)
    Toolbar mToolbar;
    @BindView(R.id.detail_bar_image)
    ImageView detailBarImg;
    @BindView(R.id.detail_bar_title)
    TextView detailBarTitle;
    @BindView(R.id.detail_bar_copyright)
    TextView detailBarCopyright;
    @BindView(R.id.wv_detail_content)
    WebView detailContentWV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        ButterKnife.bind(this);

    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        int articleId = intent.getIntExtra("articleId", 0);
        if (articleId != 0) {
            mPresenter.getStoryContent(articleId);
            mPresenter.getStoryExtras(articleId);
        } else {
            ToastUtils.showToast(this, TAG + "数据加载出错");
        }
    }

    @Override
    public void initView() {
//        setToolbar(mToolbar,"");
        initToolbar();

        initWebViewClient();
    }

    private void initToolbar() {
        mToolbar.inflateMenu(R.menu.menu_article_content);
        Menu menu = mToolbar.getMenu();
        commentProvider = (ActionProviderView) MenuItemCompat.getActionProvider(menu.findItem(R.id.action_comment));
        praiseProvider = (ActionProviderView) MenuItemCompat.getActionProvider(menu.findItem(R.id.action_praise));
        commentProvider.setImage(ContextCompat.getDrawable(this, R.drawable.comment));
        praiseProvider.setImage(ContextCompat.getDrawable(this, R.drawable.praise));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initWebViewClient() {
        WebSettings settings = detailContentWV.getSettings();
        if (SharePreferencesHelper.getInstance(this).getBoolean(Constants.WebViewSetting.SP_NO_IMAGE,false)) {
            settings.setBlockNetworkImage(true);
        }
        if (SharePreferencesHelper.getInstance(this).getBoolean(Constants.WebViewSetting.SP_AUTO_CACHE,true)) {
            settings.setAppCacheEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            if (NetUtils.isConnected(this)) {
                settings.setCacheMode(WebSettings.LOAD_DEFAULT);
            } else {
                settings.setCacheMode(WebSettings.LOAD_CACHE_ONLY);
            }
        }
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setSupportZoom(true);
        detailContentWV.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public void initListener() {
        super.initListener();
    }

    @Override
    public void showContent(StoryContentEntity storyContentEntity) {
        String imgUrl = storyContentEntity.getImage();
        GlideImageLoader.getInstance().displayImage(this, imgUrl, detailBarImg);
        detailBarTitle.setText(storyContentEntity.getTitle());
        detailBarCopyright.setText(storyContentEntity.getImage_source());
        String htmlData = HtmlUtil.createHtmlData(storyContentEntity.getBody(), storyContentEntity.getCss(), storyContentEntity.getJs());
        detailContentWV.loadData(htmlData, HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);
    }

    @Override
    public void showStoryExtras(StoryExtraEntity storyExtraEntity) {
        commentProvider.setNumInt(String.valueOf(storyExtraEntity.getComments()));
        praiseProvider.setNumInt(String.valueOf(storyExtraEntity.getPopularity()));
    }
}
