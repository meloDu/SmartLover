package com.smart.melo.smartlover.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.base.BaseFragment;
import com.smart.melo.smartlover.utils.LogUtils;
import com.smart.melo.smartlover.weight.AdvertiseView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by melo on 2017/8/11.
 * 图片浏览
 */
public class PhotoFragment extends BaseFragment {
    private static final String TAG = PhotoFragment.class.getSimpleName();
    @Bind(R.id.photo_advertiseview)
    AdvertiseView mAdvertiseView;


    List<String> data = new ArrayList<>();
    List<View> views = new ArrayList<>();

    public static Fragment newInstance() {
        Bundle args = new Bundle();
        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void lazyLoad() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_photo;
    }

    @Override
    protected void inject() {

    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        data.add("家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
        data.add("iPhone8最感人变化成真，必须买买买买!!!!");
        data.add("简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
        data.add("iPhone7价格曝光了！看完感觉我的腰子有点疼...");
        data.add("主人内疚逃命时没带够，回废墟狂挖30小时！");
        LogUtils.i(TAG,"initDataaa111111");
        setView();
        mAdvertiseView.setViews(views);

    }

    @Override
    protected void initView() {

    }

    /**
     * 初始化需要循环的View
     * 为了灵活的使用滚动的View，所以把滚动的内容让用户自定义
     * 假如滚动的是三条或者一条，或者是其他，只需要把对应的布局，和这个方法稍微改改就可以了，
     */
    private void setView() {
        for (int i = 0; i < data.size(); i ++) {
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
    public void onResume() {
        super.onResume();
        //广告位滚动
        mAdvertiseView.startRoll();
    }

    @Override
    public void onStop() {
        super.onStop();
        //广告位停止滚动
        mAdvertiseView.stopFlipping();
    }
}
