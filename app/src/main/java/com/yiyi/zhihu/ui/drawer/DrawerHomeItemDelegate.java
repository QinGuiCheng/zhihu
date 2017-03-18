package com.yiyi.zhihu.ui.drawer;

import com.yiyi.zhihu.R;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by yiyi on 2016/12/29.
 */

public class DrawerHomeItemDelegate implements ItemViewDelegate<DisplaybleItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_drawer_menu_home;
    }

    @Override
    public boolean isForViewType(DisplaybleItem item, int position) {
        return item instanceof DrawerHomeItem;
    }

    @Override
    public void convert(ViewHolder holder, DisplaybleItem displaybleItem, int position) {

    }
}
