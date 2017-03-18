package com.yiyi.zhihu.ui.main;

import com.yiyi.zhihu.api.Networks;
import com.yiyi.zhihu.entity.themeDaily.ThemesEntity;
import com.yiyi.zhihu.mvpframe.rx.RxSchedulerHelper;

import rx.Observable;

/**
 * Created by Administrator on 2016/12/31.
 */

public class DrawerMainModel implements DrawerMainContract.Model{
    @Override
    public Observable<ThemesEntity> getOtherThemeList() {
        return Networks.getInstance().getThemeApi().
                getThemes()
                .compose(RxSchedulerHelper.<ThemesEntity>io_main());
    }
}
