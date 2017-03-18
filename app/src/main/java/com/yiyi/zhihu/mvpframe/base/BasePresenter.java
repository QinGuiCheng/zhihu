package com.yiyi.zhihu.mvpframe.base;

import android.view.PixelCopy;

import com.yiyi.zhihu.mvpframe.rx.RxManager;

/**
 * Created by Administrator on 2016/12/31.
 */

public abstract class BasePresenter<M, V> {
    public M mModel;
    public V mView;
    public RxManager mRxManager = new RxManager();

    public void attachVM(V v, M m) {
        this.mModel = m;
        this.mView = v;

    }

    public void detachVM() {
        mRxManager.clear();
        mView = null;
        mModel = null;
    }

}
