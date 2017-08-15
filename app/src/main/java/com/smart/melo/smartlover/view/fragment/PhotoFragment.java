package com.smart.melo.smartlover.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.base.BaseFragment;
import com.smart.melo.smartlover.bean.PhotoBean;
import com.smart.melo.smartlover.http.UrlConfig;
import com.smart.melo.smartlover.presenter.PhotoPresenter;
import com.smart.melo.smartlover.utils.LogUtils;
import com.smart.melo.smartlover.utils.ToastUtils;
import com.smart.melo.smartlover.view.adapter.PhotoRecyclerAdapter;
import com.smart.melo.smartlover.view.impl.IBaseView;
import com.smart.melo.smartlover.view.injector.compontent.DaggerPhotoFragmentComponent;
import com.smart.melo.smartlover.view.injector.module.PhotoFragmentModule;
import com.smart.melo.smartlover.weight.AdvertiseView;
import com.smart.melo.smartlover.weight.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by melo on 2017/8/11.
 * 图片浏览
 */
public class PhotoFragment extends BaseFragment {
    private static final String TAG = PhotoFragment.class.getSimpleName();
    @Bind(R.id.photo_advertiseview)
    AdvertiseView mAdvertiseView;
    @Bind(R.id.rv_photo)
    RecyclerView mRvPhoto;

    @Inject
    PhotoPresenter mPhotoPresenter;

    List<String> data = new ArrayList<>();
    List<View> views = new ArrayList<>();


    public static PhotoFragment newInstance() {
        Bundle args = new Bundle();
        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void lazyLoad() {
    }

    @Override
    protected void disappear() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_photo;
    }

    @Override
    protected void inject() {
        DaggerPhotoFragmentComponent.builder()
                .photoFragmentModule(new PhotoFragmentModule(mIBaseView))
                .build()
                .inject(this);
        LogUtils.i(TAG, "inject");
    }


    //数据源
    private List<PhotoBean.ResultsBean> photolList = new ArrayList<>();
    //list适配器
    private PhotoRecyclerAdapter adaper;

    @Override
    protected void initData() {
        LogUtils.i(TAG, "initData");
        data = new ArrayList<>();
        data.add("即使爬到最高的山上，一次也只能脚踏实地地迈一步。");
        data.add("积极思考造成积极人生，消极思考造成消极人生");
        data.add("人之所以有一张嘴，而有两只耳朵，原因是听的要比说的多一倍");
        data.add("别想一下造出大海，必须先由小河川开始");
        data.add("有事者，事竟成；破釜沉舟，百二秦关终归楚；苦心人，天不负；卧薪尝胆，三千越甲可吞吴");
        setView();
        mAdvertiseView.setViews(views);
        //适配图片
        adaper = new PhotoRecyclerAdapter(getActivity(), photolList);
        mRvPhoto.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mRvPhoto.setAdapter(adaper);
        //设置item之间的间隔
        SpaceItemDecoration decoration=new SpaceItemDecoration(16);
        mRvPhoto.addItemDecoration(decoration);
    }


    @Override
    protected void initView() {
        LogUtils.i(TAG, "initView");
    }


    //接收数据
    private IBaseView mIBaseView = new IBaseView() {
        @Override
        public void OnMsgSuccess(Object o) {
            dismissDiaLog();
            //将数据装进集合
            PhotoBean photoBean = (PhotoBean) o;
            photolList.addAll(photoBean.getResults());
            adaper.notifyDataSetChanged();
            LogUtils.i(TAG, photoBean.getResults().get(0).getUrl());
        }

        @Override
        public void onFail(String msg) {
            ToastUtils.show(getActivity(), "下载失败");
        }
    };

    /**
     * 初始化需要循环的View
     * 为了灵活的使用滚动的View，所以把滚动的内容让用户自定义
     * 假如滚动的是三条或者一条，或者是其他，只需要把对应的布局，和这个方法稍微改改就可以了，
     */
    private void setView() {
        for (int i = 0; i < data.size(); i++) {
            //设置滚动的单个布局
            LinearLayout view = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.item_advertiseview, null);
            //初始化布局的控件
            TextView tv1 = (TextView) view.findViewById(R.id.advertise_tv1);
            //进行对控件赋值
            tv1.setText(data.get(i).toString());
            //添加到循环滚动数组里面去
            views.add(view);
        }
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            //隐藏
            //广告位停止滚动
            mAdvertiseView.stopRoll();
        } else {
            //显示
            //广告位滚动
            mAdvertiseView.startRoll();
        }
        LogUtils.i(TAG, "hidden：" + hidden);
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.i(TAG, "onResume：");
        //广告位滚动
        mAdvertiseView.startRoll();
        showDiaLog();
        mPhotoPresenter.pPhotoMsg(UrlConfig.RequestColumn.TYPE,
                UrlConfig.RequestColumn.AMOUNT,
                UrlConfig.RequestColumn.PAGE);
    }

}
