package com.yiyi.zhihu.ui.detail;

import com.yiyi.zhihu.entity.commonEntity.StoryContentEntity;
import com.yiyi.zhihu.entity.commonEntity.StoryExtraEntity;
import com.yiyi.zhihu.mvpframe.base.BaseModel;
import com.yiyi.zhihu.mvpframe.base.BasePresenter;
import com.yiyi.zhihu.mvpframe.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2017/1/12.
 */

public interface DetailContract {

    interface Model extends BaseModel {
        Observable<StoryContentEntity> getStoryContent(int id);
        Observable<StoryExtraEntity> getStoryExtras(int id);
    }

    interface View extends BaseView {
        void showContent(StoryContentEntity storyContentEntity);
        void showStoryExtras(StoryExtraEntity storyExtraEntity);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        abstract void getStoryContent(int id);
        abstract void getStoryExtras(int id);
    }
}
