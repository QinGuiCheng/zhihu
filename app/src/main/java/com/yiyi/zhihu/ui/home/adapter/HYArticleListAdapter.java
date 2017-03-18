package com.yiyi.zhihu.ui.home.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.yiyi.zhihu.ui.drawer.DisplaybleItem;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public class HYArticleListAdapter extends MultiItemTypeAdapter<DisplaybleItem> {

    public HYArticleListAdapter(Context context, List<DisplaybleItem> datas) {
        super(context, datas);

        addItemViewDelegate(new HomeHeaderItemDelegate());
        addItemViewDelegate(new HomeSectionItemDelegate());
        addItemViewDelegate(new ArticleItemDelegate());
        addItemViewDelegate(new ThemeSectionItemDelegate());
        addItemViewDelegate(new ThemeHeaderItemDelegate());
    }

}
