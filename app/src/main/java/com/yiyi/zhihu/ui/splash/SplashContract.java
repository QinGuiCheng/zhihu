package com.yiyi.zhihu.ui.splash;

import com.yiyi.zhihu.entity.commonEntity.SplashImgEntity;
import com.yiyi.zhihu.mvpframe.base.BaseModel;
import com.yiyi.zhihu.mvpframe.base.BasePresenter;
import com.yiyi.zhihu.mvpframe.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2017/1/3.
 */

public interface SplashContract {
    interface Model extends BaseModel{
        Observable<SplashImgEntity> getSplahImg();
    }

    interface View extends BaseView{
        void loadSplashImage(SplashImgEntity splashImgEntity);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        abstract void getSplashImage();
    }
}
