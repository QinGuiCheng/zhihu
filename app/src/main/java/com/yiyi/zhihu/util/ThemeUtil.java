package com.yiyi.zhihu.util;

import android.content.Context;

import com.yiyi.zhihu.global.Constants;

/**
 * 主题帮助类
 * Created by yiyi on 2016/12/28.
 */

public class ThemeUtil {

    private SharePreferencesHelper mSPHelper;

    private static ThemeUtil mThemeUtil;

    public static ThemeUtil getInstance(Context context) {
        if (mThemeUtil == null) {
            mThemeUtil = new ThemeUtil(context);
        }
        return mThemeUtil;
    }

    public ThemeUtil(Context context) {
        mSPHelper = SharePreferencesHelper.getInstance(context);
    }

    /**
     * 保存主题设置
     * @param theme
     */
    public void setTheme(String theme) {
        mSPHelper.putString(Constants.Key.THEME_MODE, theme);
    }

    /**
     * 取出当前主题
     */
    public String getTheme() {
       return mSPHelper.getString(Constants.Key.THEME_MODE, Constants.Theme.DAY_THEME);
    }


}
