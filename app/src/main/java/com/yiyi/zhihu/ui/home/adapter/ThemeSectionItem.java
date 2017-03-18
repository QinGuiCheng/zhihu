package com.yiyi.zhihu.ui.home.adapter;

import com.yiyi.zhihu.entity.themeDaily.EditorsEntity;
import com.yiyi.zhihu.ui.drawer.DisplaybleItem;

import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */

public class ThemeSectionItem implements DisplaybleItem {

    private List<EditorsEntity> mEditors;

    public ThemeSectionItem(List<EditorsEntity> editors) {
        mEditors = editors;
    }

    public List<EditorsEntity> getEditors() {
        return mEditors;
    }

    public void setEditors(List<EditorsEntity> editors) {
        mEditors = editors;
    }
}
