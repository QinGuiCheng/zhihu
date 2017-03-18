package com.yiyi.zhihu.ui.home.adapter;

import com.yiyi.zhihu.ui.drawer.DisplaybleItem;

/**
 * Created by Administrator on 2017/1/6.
 */

public class ThemeHeaderItem implements DisplaybleItem {
    private String image;
    private String description;

    public ThemeHeaderItem(String image, String description) {
        this.image = image;
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
