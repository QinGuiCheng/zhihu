package com.yiyi.zhihu.ui.editor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.yiyi.zhihu.R;
import com.yiyi.zhihu.common.BaseActivity;
import com.yiyi.zhihu.entity.themeDaily.EditorsEntity;
import com.yiyi.zhihu.loader.GlideImageLoader;
import com.yiyi.zhihu.mvpframe.base.BaseFrameActivity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditorListActivity extends BaseActivity {

    private static final String TAG = "EditorListActivity";

    @BindView(R.id.toolBar)
    Toolbar mToolbar;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private ArrayList<EditorsEntity> editors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_list);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        editors = new ArrayList<>();
        Intent intent = getIntent();
        editors = intent.getParcelableArrayListExtra("editors");
    }

    @Override
    public void initView() {
        setToolbar(mToolbar, this.getResources().getString(R.string.editor_in_chief));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(new CommonAdapter<EditorsEntity>(this, R.layout.item_editor_list, editors) {
            @Override
            protected void convert(final ViewHolder holder, final EditorsEntity editorsEntity, int position) {
                final Context context = this.mContext;
                ImageView avatorIV = holder.getView(R.id.avator_iv);
                GlideImageLoader.getInstance().displayCircleImage(context, editorsEntity.getAvatar(), avatorIV);

                holder.setText(R.id.name_tv, editorsEntity.getName());
                holder.setText(R.id.bio_tv, editorsEntity.getBio());

                holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, EditorDetailActivity.class);
                        intent.putExtra("editorId",editorsEntity.getId());
                        context.startActivity(intent);
                    }
                });
            }
        });
    }
}
