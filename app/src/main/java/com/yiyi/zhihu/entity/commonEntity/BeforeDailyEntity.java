package com.yiyi.zhihu.entity.commonEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public class BeforeDailyEntity {

    /**
     * date : 20170102
     * stories : [{"images":["http://pic4.zhimg.com/5615a788a32c2cc9469f825c4622879b.jpg"],"type":0,"id":9115087,"ga_prefix":"010222","title":"小事 · 悲喜无常"},"..."]
     */

    private String date;
    private List<StoriesEntity> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesEntity> getStories() {
        return stories;
    }

    public void setStories(List<StoriesEntity> stories) {
        this.stories = stories;
    }

}
