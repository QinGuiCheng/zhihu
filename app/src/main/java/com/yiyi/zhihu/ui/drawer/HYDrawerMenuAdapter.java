package com.yiyi.zhihu.ui.drawer;

import android.content.Context;
import android.nfc.cardemulation.HostApduService;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yiyi.zhihu.R;
import com.yiyi.zhihu.global.Constants;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by yiyi on 2016/12/29.
 */

public class HYDrawerMenuAdapter extends MultiItemTypeAdapter<DisplaybleItem> {

    private int mSelection = 1;

    private onItemClickListener mOnItemClickListener;

    public HYDrawerMenuAdapter(Context context, List<DisplaybleItem> datas) {
        super(context, datas);

        addItemViewDelegate(new DrawerHeaderItemDelegate());
        addItemViewDelegate(new DrawerHomeItemDelegate());
        addItemViewDelegate(new DrawerContentItemDelegate());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        if (mSelection == position) {
            holder.getConvertView().setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorLightGray));
        } else if (position > 0){
            holder.getConvertView().setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorWhite));
        }
    }

    @Override
    protected void setListener(ViewGroup parent, final ViewHolder viewHolder, int viewType) {

        switch (viewType) {
            case Constants.DrawerMenuItemType.ITEM_DRAWER_MENU_HEADER:
                ImageView userIcon = (ImageView) viewHolder.getView(R.id.user_icon);
                TextView loginTV = (TextView)viewHolder.getView(R.id.login);
                Button favoritesBtn = (Button)viewHolder.getView(R.id.action_favorites);
                Button downloadBtn = (Button)viewHolder.getView(R.id.action_download);

                userIcon.setOnClickListener(handler);
                loginTV.setOnClickListener(handler);
                favoritesBtn.setOnClickListener(handler);
                downloadBtn.setOnClickListener(handler);

                break;

            case Constants.DrawerMenuItemType.ITEM_DRAWER_MENU_HOME:
            case Constants.DrawerMenuItemType.ITEM_DRAWER_MENU_CONTENT:
                final int offset = Constants.DrawerMenuItemType.ITEM_DRAWER_MENU_CONTENT;

                viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mOnItemClickListener != null) {
                            int position = viewHolder.getAdapterPosition();
                            mOnItemClickListener.onItemViewClick(v, viewHolder, position);
                        }
                    }
                });

                if (viewType == Constants.DrawerMenuItemType.ITEM_DRAWER_MENU_CONTENT) {
                    viewHolder.getView(R.id.follow_iv).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (mOnItemClickListener != null) {
                                int position = viewHolder.getAdapterPosition();
                                mOnItemClickListener.onFollowIVClick(view, viewHolder, position, offset);
                            }
                        }
                    });
                }

                break;
        }

    }

    private View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onDrawerHeaderItemClick();
            }
        }
    };

    public void setSelection(int selection) {
        mSelection = selection;
    }

    public interface onItemClickListener {
        void onDrawerHeaderItemClick();

        void onItemViewClick(View view, RecyclerView.ViewHolder holder, int position);

        void onFollowIVClick(View view, RecyclerView.ViewHolder holder, int position, int offset);
    }

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
}
