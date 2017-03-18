package com.yiyi.zhihu.ui.splash;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tbruyelle.rxpermissions.Permission;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.yiyi.zhihu.R;
import com.yiyi.zhihu.entity.commonEntity.SplashImgEntity;
import com.yiyi.zhihu.loader.GlideImageLoader;
import com.yiyi.zhihu.mvpframe.base.BaseFrameActivity;
import com.yiyi.zhihu.mvpframe.rx.RxSchedulerHelper;
import com.yiyi.zhihu.ui.main.MainActivity;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;

public class SplashActivity extends BaseFrameActivity<SplashPresenter, SplashModel> implements SplashContract.View{

    @BindView(R.id.splash_image)
    ImageView mSplashImgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {
        mPresenter.getSplashImage();
    }

    @Override
    public void loadSplashImage(SplashImgEntity splashImgEntity) {
        //Glide.with(this).load(splashImgEntity.getImg()).into(mSplashImgView);
        GlideImageLoader.getInstance().displayImage(this, splashImgEntity.getImg(), mSplashImgView);
    }

    @Override
    public void onRequestEnd() {
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .compose(RxPermissions.getInstance(this).ensureEach(Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE))
                .compose(RxSchedulerHelper.<Permission>io_main())
                .subscribe(new Subscriber<Permission>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Permission permission) {
                        if (permission.granted) {
                            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }
}
