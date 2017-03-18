package com.yiyi.zhihu.api;

import com.yiyi.zhihu.entity.themeDaily.ThemeContentListEntity;
import com.yiyi.zhihu.entity.themeDaily.ThemesEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yiyi on 2016/12/27.
 */

public interface ThemeApi {
    /**
     * 获取主题日报列表theme
     */
    @GET("themes")
    Observable<ThemesEntity> getThemes();

    /**
     * 获取主题日报内容列表
     * @param themeId 主题日报id
     */
    @GET("theme/{themeId}")
    Observable<ThemeContentListEntity> getThemeContentList(@Path("themeId") int themeId);

}
