package com.yiyi.zhihu.ui.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yiyi.zhihu.R;
import com.yiyi.zhihu.entity.commonEntity.BeforeDailyEntity;
import com.yiyi.zhihu.entity.commonEntity.LatestDailyEntity;
import com.yiyi.zhihu.entity.themeDaily.ThemeContentListEntity;
import com.yiyi.zhihu.global.Constants;
import com.yiyi.zhihu.mvpframe.base.BaseFrameFragment;
import com.yiyi.zhihu.ui.drawer.DisplaybleItem;
import com.yiyi.zhihu.ui.home.adapter.HYArticleListAdapter;
import com.yiyi.zhihu.ui.home.adapter.HomeHeaderItem;
import com.yiyi.zhihu.ui.home.adapter.HomeSectionItem;
import com.yiyi.zhihu.ui.home.adapter.ThemeHeaderItem;
import com.yiyi.zhihu.ui.home.adapter.ThemeSectionItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/4.
 */

public class HomeFragment extends BaseFrameFragment<HomePresenter, HomeModel> implements HomeContract.View {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeRefresh;

    private HYArticleListAdapter mArticleListAdapter;

    private List<DisplaybleItem> mArticleList;

    // 用于获取以前的文章列表
    private String mdate;

    public String TYPE = Constants.StoryType.STORY_HOME;

    public int themeId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        ButterKnife.bind(this, getContentView());

    }

    @Override
    public void initData() {
        mArticleList = new ArrayList<>();
        mArticleListAdapter = new HYArticleListAdapter(getContext(), mArticleList);
    }

    @Override
    public void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mArticleListAdapter);
    }

    @Override
    public void initListener() {
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (TYPE.equals(Constants.StoryType.STORY_THEME)) return;
                View lastchildView = recyclerView.getLayoutManager().getChildAt(recyclerView.getLayoutManager().getChildCount() - 1);
                int lastChildBottomY = lastchildView.getBottom();
                int recyclerBottomY = recyclerView.getBottom() - recyclerView.getPaddingBottom();
                int lastPosition = recyclerView.getLayoutManager().getPosition(lastchildView);

                if (lastChildBottomY == recyclerBottomY && newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {
                    mPresenter.getBeforeDaily(mdate);
                }
            }
        });
    }

    @Override
    public void initLoad() {
        getData();
    }

    public void getData() {
        if (TYPE.equals(Constants.StoryType.STORY_HOME)) {
            mPresenter.getLatestDaily();
        } else {
            mPresenter.getOtherThemeList(themeId);
        }
    }

    @Override
    public <T> void refreshHomeList(T t) {
        mArticleList.clear();

        if (TYPE == Constants.StoryType.STORY_HOME) {
            LatestDailyEntity latestDailyEntity = (LatestDailyEntity)t;
            mdate = latestDailyEntity.getDate();

            mArticleList.add(new HomeHeaderItem(latestDailyEntity.getTop_stories()));
            mArticleList.add(new HomeSectionItem(mdate));
            mArticleList.addAll(latestDailyEntity.getStories());
        } else {
            ThemeContentListEntity themeContentListEntity = (ThemeContentListEntity)t;

            mArticleList.add(new ThemeHeaderItem(themeContentListEntity.getImage(), themeContentListEntity.getDescription()));
            mArticleList.add(new ThemeSectionItem(themeContentListEntity.getEditors()));
            mArticleList.addAll(themeContentListEntity.getStories());
        }

        mArticleListAdapter.notifyDataSetChanged();
        mRecyclerView.scrollToPosition(0);
        mSwipeRefresh.setRefreshing(false);
    }

    @Override
    public void loadBeforeDaily(BeforeDailyEntity beforeDailyEntity) {
        mdate = beforeDailyEntity.getDate();

        mArticleList.add(new HomeSectionItem(mdate));
        mArticleList.addAll(beforeDailyEntity.getStories());
        mArticleListAdapter.notifyDataSetChanged();
    }

}
