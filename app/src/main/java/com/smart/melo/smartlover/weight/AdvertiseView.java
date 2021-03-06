package com.smart.melo.smartlover.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.smart.melo.smartlover.R;

import java.util.List;

/**
 * 垂直滚动的自定义View
 *
 * Created by melo on 2017/8/11.
 */
public class AdvertiseView extends ViewFlipper {
 
    private Context mContext;
    private boolean isSetAnimDuration = false;
    private int interval = 2000;
    /**
     * 动画时间
     */
    private int animDuration = 500;
 
    public AdvertiseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }
 
    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        this.mContext = context;
        setFlipInterval(interval);
        Animation animIn = AnimationUtils.loadAnimation(mContext, R.anim.pop_in);
        if (isSetAnimDuration) animIn.setDuration(animDuration);
        setInAnimation(animIn);
        Animation animOut = AnimationUtils.loadAnimation(mContext, R.anim.pop_out);
        if (isSetAnimDuration) animOut.setDuration(animDuration);
        setOutAnimation(animOut);
    }
 
 
    /**
     * 设置循环滚动的View数组
     *
     * @param views
     */
    public void setViews(List<View> views) {
        if (views == null || views.size() == 0) {
            return;
        }
        removeAllViews();
        for (int i = 0; i < views.size(); i++) {
            addView(views.get(i));
        }


    }

    /**
     * 开始滚动
     */
    public void startRoll() {
        if (!isFlipping()){
            startFlipping();
        }
    }

    /**
     * 停止滚动
     */
    public void stopRoll() {
        if (isFlipping()){
            stopFlipping();
        }
    }
 
 
}