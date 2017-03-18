package com.yiyi.zhihu.ui.home;

import com.yiyi.zhihu.entity.commonEntity.BeforeDailyEntity;
import com.yiyi.zhihu.entity.commonEntity.LatestDailyEntity;
import com.yiyi.zhihu.entity.themeDaily.ThemeContentListEntity;
import com.yiyi.zhihu.mvpframe.base.BaseModel;
import com.yiyi.zhihu.mvpframe.base.BasePresenter;
import com.yiyi.zhihu.mvpframe.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2017/1/4.
 */

public interface HomeContract {

    interface Model extends BaseModel {
        Observable<LatestDailyEntity> getLatestDaily();

        Observable<BeforeDailyEntity> getBeforeDaily(String date);

        Observable<ThemeContentListEntity> getThemeContentList(int id);
    }

    interface View extends BaseView {
        <T> void refreshHomeList(T t);

        void loadBeforeDaily(BeforeDailyEntity beforeDailyEntity);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        abstract void getLatestDaily();

        abstract void getBeforeDaily(String date);

        abstract void getOtherThemeList(int id);
    }
}
