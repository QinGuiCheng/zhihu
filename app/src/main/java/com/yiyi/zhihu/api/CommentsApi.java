package com.yiyi.zhihu.api;

import com.yiyi.zhihu.entity.comments.LongCommentsEntity;
import com.yiyi.zhihu.entity.comments.ShortCommentsEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yiyi on 2016/12/27.
 */

public interface CommentsApi {
    /**
     * 获取文章长评论
     * @param storyId
     */
    @GET("story/{storyId}/long-comments")
    Observable<LongCommentsEntity> getLongComments(@Path("storyId") int storyId);

    /**
     * 获取文章短评论
     * @param storyId
     */
    @GET("story/{storyId}/short-comments")
    Observable<ShortCommentsEntity> getShortComments(@Path("storyId") int storyId);
}
