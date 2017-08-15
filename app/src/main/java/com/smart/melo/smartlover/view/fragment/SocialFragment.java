package com.smart.melo.smartlover.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.base.BaseFragment;
import com.smart.melo.smartlover.bean.SocialBean;
import com.smart.melo.smartlover.presenter.SocialPresenter;
import com.smart.melo.smartlover.utils.LogUtils;
import com.smart.melo.smartlover.utils.ToastUtils;
import com.smart.melo.smartlover.view.activity.TopDetailsActivity;
import com.smart.melo.smartlover.view.adapter.SocialListViewAdaper;
import com.smart.melo.smartlover.view.impl.IBaseView;
import com.smart.melo.smartlover.view.injector.compontent.DaggerSocialFragmentComponent;
import com.smart.melo.smartlover.view.injector.module.SocialFragmentModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by melo on 2017/8/14.
 */
public class SocialFragment extends BaseFragment {

    private static final String TAG = SocialFragment.class.getSimpleName();
    @Inject
    SocialPresenter mSocialPresenter;
    @Bind(R.id.lv_top)
    ListView mLvTop;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;


    /**
     * 标志位，标志已经初始化完成
     */
    private boolean isPrepared;

    /**
     * 是否已被加载过一次，第二次就不再去请求数据了
     */
    private boolean mHasLoadedOnce;


    //加载初始页
    int page = 0;

    public static SocialFragment newInstance() {
        Bundle args = new Bundle();
        SocialFragment fragment = new SocialFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void lazyLoad() {
        Log.i(TAG, "appear  isVisible:"+isVisible);
        if (!isPrepared || !isVisible || mHasLoadedOnce) {
            return;
        }
        //下载初始数据
        showDiaLog();
        mSocialPresenter.pSocialMsg(String.valueOf(page));

    }

    @Override
    protected void disappear() {
        Log.i(TAG, "disappear  isVisible:"+isVisible);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_top;
    }

    @Override
    protected void inject() {
        DaggerSocialFragmentComponent.builder()
                .socialFragmentModule(new SocialFragmentModule(mIBaseView))
                .build()
                .inject(this);

    }

    //list适配器
   private SocialListViewAdaper adaper;


    @Override
    protected void initData() {
        //适配数据
        adaper = new SocialListViewAdaper(getActivity(), totalList);
        mLvTop.setAdapter(adaper);

    }

    @Override
    protected void initView() {
        Log.i(TAG, "isVisible:"+isVisible);
        isPrepared = true;

        //下拉刷新监听
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                totalList.clear();
                page = 0;
                mSocialPresenter.pSocialMsg(String.valueOf(page));
                refreshlayout.finishRefresh(1000);
            }
        });
        //上啦加载监听
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                mSocialPresenter.pSocialMsg(String.valueOf(page));
                refreshlayout.finishLoadmore(1000);
            }
        });

        //listview  itemd点击事件
        mLvTop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url = totalList.get(i).getUrl();
                LogUtils.i(TAG, url);
                Intent intent = new Intent(getActivity(), TopDetailsActivity.class);
                intent.putExtra("detailsUrl", url);
                getActivity().startActivity(intent);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    //数据源
    List<SocialBean.ResultBean.DataBean> totalList = new ArrayList<>();

    private IBaseView mIBaseView = new IBaseView() {
        @Override
        public void OnMsgSuccess(Object o) {
            mHasLoadedOnce = true;
            //关闭加载提示
            dismissRefresh();
            //将数据装进集合
            SocialBean socialBean = (SocialBean) o;
            totalList.addAll(socialBean.getResult().getData());
            adaper.notifyDataSetChanged();
            LogUtils.i(TAG, socialBean.getResult().getData().get(0).getTitle());
        }

        @Override
        public void onFail(String msg) {
            ToastUtils.show(getActivity(), "下载失败");
        }
    };


    //关闭加载提示
    private void dismissRefresh() {
        if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadmore();
        } else if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.finishRefresh();
        } else {
            dismissDiaLog();
        }
    }
}
