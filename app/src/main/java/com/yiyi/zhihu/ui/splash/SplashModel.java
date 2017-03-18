package com.yiyi.zhihu.ui.splash;

import com.yiyi.zhihu.api.Networks;
import com.yiyi.zhihu.entity.commonEntity.SplashImgEntity;
import com.yiyi.zhihu.mvpframe.rx.RxSchedulerHelper;

import rx.Observable;

/**
 * Created by Administrator on 2017/1/3.
 */

public class SplashModel implements SplashContract.Model{
    @Override
    public Observable<SplashImgEntity> getSplahImg() {
        return Networks.getInstance().
                getCommonApi().
                getSplashImg().
                compose(RxSchedulerHelper.<SplashImgEntity>io_main());

    }
}
