package com.yiyi.zhihu.ui.home;

import com.yiyi.zhihu.api.Networks;
import com.yiyi.zhihu.entity.commonEntity.BeforeDailyEntity;
import com.yiyi.zhihu.entity.commonEntity.LatestDailyEntity;
import com.yiyi.zhihu.entity.themeDaily.ThemeContentListEntity;
import com.yiyi.zhihu.mvpframe.rx.RxSchedulerHelper;

import rx.Observable;

/**
 * Created by Administrator on 2017/1/4.
 */

public class HomeModel implements HomeContract.Model {

    @Override
    public Observable<LatestDailyEntity> getLatestDaily() {
        return Networks.getInstance().getCommonApi().getLatestDaily()
                .compose(RxSchedulerHelper.<LatestDailyEntity>io_main());
    }

    @Override
    public Observable<BeforeDailyEntity> getBeforeDaily(String date) {
        return Networks.getInstance().getCommonApi().getBeforeDaily(date)
                .compose(RxSchedulerHelper.<BeforeDailyEntity>io_main());
    }

    @Override
    public Observable<ThemeContentListEntity> getThemeContentList(int id) {
        return Networks.getInstance().getThemeApi().getThemeContentList(id)
                .compose(RxSchedulerHelper.<ThemeContentListEntity>io_main());
    }
}
