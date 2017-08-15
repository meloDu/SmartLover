package com.smart.melo.smartlover.view.activity;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.widget.RadioGroup;

import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.base.BaseActivity;
import com.smart.melo.smartlover.utils.BottomTabManager;
import com.smart.melo.smartlover.view.fragment.MineFragment;
import com.smart.melo.smartlover.view.fragment.NewsFragment;
import com.smart.melo.smartlover.view.fragment.PhotoFragment;
import com.smart.melo.smartlover.view.fragment.VideoFragment;

import java.util.ArrayList;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements BottomTabManager.OnBottomTabSelectListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    //默认选中的页面下标
    public static final int CHECK_HOME_INDEX = 0;
    public static final int CHECK_PHOTO_INDEX = 1;
    public static final int CHECK_VIDEO_INDEX = 2;
    public static final int CHECK_MINE_INDEX = 3;

    @Bind(R.id.radiogroup_bottom)
    RadioGroup mRadiogroupBottom;

    @Override
    protected void initView() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(NewsFragment.newInstance());
        fragments.add(PhotoFragment.newInstance());
        fragments.add(VideoFragment.newInstance());
        fragments.add(MineFragment.newInstance());
        new BottomTabManager(fragments, mRadiogroupBottom, getSupportFragmentManager(),
                R.id.layout_content
                , this);


    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onDestroyed() {

    }

    @Override
    public void onBottomTabSelectListener(RadioGroup group, int checkedId, int index) {
        switch (index) {
            case CHECK_HOME_INDEX:
                break;
            case CHECK_PHOTO_INDEX:
                break;
            case CHECK_VIDEO_INDEX:
                break;
            case CHECK_MINE_INDEX:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        new AlertDialog.Builder(this).setMessage("确定退出？").setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).show();
        return super.onKeyDown(keyCode, event);
    }
}
