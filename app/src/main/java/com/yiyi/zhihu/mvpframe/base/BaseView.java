package com.yiyi.zhihu.mvpframe.base;

import android.content.Context;

/**
 * Created by Administrator on 2016/12/31.
 */

public interface BaseView {

    //void showError(String msg);

    void onRequestStart();
    void onRequestError(String msg);
    void onRequestEnd();
    void onInternetError();
}
