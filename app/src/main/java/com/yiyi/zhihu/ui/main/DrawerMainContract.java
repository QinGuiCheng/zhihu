package com.yiyi.zhihu.ui.main;

import android.view.View;

import com.yiyi.zhihu.entity.themeDaily.ThemesEntity;
import com.yiyi.zhihu.mvpframe.base.BaseModel;
import com.yiyi.zhihu.mvpframe.base.BasePresenter;
import com.yiyi.zhihu.mvpframe.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2016/12/31.
 */

public interface DrawerMainContract {

    interface Model extends BaseModel {
        Observable<ThemesEntity> getOtherThemeList();
    }

    interface View extends BaseView {
        void loadOtherThemeList(ThemesEntity themesEntity);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        abstract void getOtherThemes();
    }
}
