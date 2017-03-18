package com.yiyi.zhihu.ui.home.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yiyi.zhihu.R;
import com.yiyi.zhihu.loader.GlideImageLoader;
import com.yiyi.zhihu.ui.drawer.DisplaybleItem;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by Administrator on 2017/1/9.
 */

public class ThemeHeaderItemDelegate implements ItemViewDelegate<DisplaybleItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.theme_header;
    }

    @Override
    public boolean isForViewType(DisplaybleItem item, int position) {
        return item instanceof ThemeHeaderItem;
    }

    @Override
    public void convert(ViewHolder holder, DisplaybleItem displaybleItem, int position) {
        ThemeHeaderItem item = (ThemeHeaderItem)displaybleItem;

        holder.setText(R.id.theme_header_tv, item.getDescription());

        ImageView iv = (ImageView) holder.getView(R.id.theme_header_iv);
        //Glide.with(holder.getConvertView().getContext()).load(item.getImage()).into(iv);
        GlideImageLoader.getInstance().displayImage(holder.getConvertView().getContext(), item.getImage(), iv);
    }
}
