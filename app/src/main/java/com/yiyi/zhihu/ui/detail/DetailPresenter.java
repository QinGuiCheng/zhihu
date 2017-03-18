package com.yiyi.zhihu.ui.detail;

import com.yiyi.zhihu.entity.commonEntity.StoryContentEntity;
import com.yiyi.zhihu.entity.commonEntity.StoryExtraEntity;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/1/12.
 */

public class DetailPresenter extends DetailContract.Presenter {
    @Override
    void getStoryContent(int id) {
        mRxManager.add(mModel.getStoryContent(id)
        .subscribe(new Subscriber<StoryContentEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(StoryContentEntity storyContentEntity) {
                mView.showContent(storyContentEntity);
            }
        }));
    }

    @Override
    void getStoryExtras(int id) {
        mRxManager.add(mModel.getStoryExtras(id)
        .subscribe(new Subscriber<StoryExtraEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(StoryExtraEntity storyExtraEntity) {
                mView.showStoryExtras(storyExtraEntity);
            }
        }));
    }
}
