package com.smart.melo.smartlover.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.bean.TopBean;
import com.smart.melo.smartlover.utils.ImageLoadHelper;

import java.util.List;

/**
 * Created by melo on 2017/8/10.
 */
public class TopListViewAdaper extends BaseAdapter {

    public static final int TYPT_NO_IMG = 0;// 4种不同的布局
    public static final int TYPT_ONE_IMG = 1;
    public static final int TYPT_TWO_IMG = 2;
    public static final int TYPT_THREE_IMG = 3;


    private Context mContext;
    private LayoutInflater mInflater;
    private List<TopBean.ResultBean.DataBean> mDataBeanList;

    private ViewHolderNoImg mViewHolderNoImg;
    private ViewHolderOneImg mViewHolderOneImg;
    private ViewHolderTwoImg mViewHolderTwoImg;
    private ViewHolderThreeImg mViewHolderThreeImg;


    public TopListViewAdaper(Context mContext, List<TopBean.ResultBean.DataBean> mDataBeanList) {
        this.mDataBeanList = mDataBeanList;
        this.mContext = mContext;
        mInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataBeanList != null ? mDataBeanList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return mDataBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int i) {
        int count = 0;
        if (mDataBeanList.get(i).getThumbnail_pic_s() != null) {
            count++;
        }

        if (mDataBeanList.get(i).getThumbnail_pic_s02() != null) {
            count++;
        }
        if (mDataBeanList.get(i).getThumbnail_pic_s03() != null) {
            count++;
        }

        switch (count) {
            case 0:
                return TYPT_NO_IMG;
            case 1:
                return TYPT_ONE_IMG;
            case 2:
                return TYPT_TWO_IMG;
            case 3:
                return TYPT_THREE_IMG;
        }
        return 0;

    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        int type = getItemViewType(i);
        if (convertView == null) {
            switch (type) {
                case TYPT_NO_IMG:
                    mViewHolderNoImg = new ViewHolderNoImg();
                    convertView = mInflater.inflate(R.layout.item_lv_top_noimg, null);
                    mViewHolderNoImg.mTextView = (TextView) convertView.findViewById(R.id.tv_toplv_noimg);
                    convertView.setTag(mViewHolderNoImg);
                    break;
                case TYPT_ONE_IMG:
                    mViewHolderOneImg = new ViewHolderOneImg();
                    convertView = mInflater.inflate(R.layout.item_lv_top_oneimg, null);
                    mViewHolderOneImg.mTextView = (TextView) convertView.findViewById(R.id.tv_lv_top_typeone);
                    mViewHolderOneImg.mImageView = (ImageView) convertView.findViewById(R.id.iv_lv_top_typeone);
                    convertView.setTag(mViewHolderOneImg);
                    break;
                case TYPT_TWO_IMG:
                    mViewHolderTwoImg = new ViewHolderTwoImg();
                    convertView = mInflater.inflate(R.layout.item_lv_top_twoimg, null);
                    mViewHolderTwoImg.mTextView = (TextView) convertView.findViewById(R.id.tv_lv_top_typetwo);
                    mViewHolderTwoImg.mImageView1 = (ImageView) convertView.findViewById(R.id.iv1_lv_top_typetwo);
                    mViewHolderTwoImg.mImageView2 = (ImageView) convertView.findViewById(R.id.iv2_lv_top_typetwo);
                    convertView.setTag(mViewHolderTwoImg);

                    break;
                case TYPT_THREE_IMG:
                    mViewHolderThreeImg = new ViewHolderThreeImg();
                    convertView = mInflater.inflate(R.layout.item_lv_top_threeimg, null);
                    mViewHolderThreeImg.mTextView = (TextView) convertView.findViewById(R.id.tv_lv_top_typethree);
                    mViewHolderThreeImg.mImageView1 = (ImageView) convertView.findViewById(R.id.iv1_lv_top_typethree);
                    mViewHolderThreeImg.mImageView2 = (ImageView) convertView.findViewById(R.id.iv2_lv_top_typethree);
                    mViewHolderThreeImg.mImageView3 = (ImageView) convertView.findViewById(R.id.iv3_lv_top_typethree);
                    convertView.setTag(mViewHolderThreeImg);
                    break;

            }
        } else {
            switch (type) {
                case TYPT_NO_IMG:
                    mViewHolderNoImg = (ViewHolderNoImg) convertView.getTag();
                    break;
                case TYPT_ONE_IMG:
                    mViewHolderOneImg = (ViewHolderOneImg) convertView.getTag();
                    break;
                case TYPT_TWO_IMG:
                    mViewHolderTwoImg = (ViewHolderTwoImg) convertView.getTag();

                    break;
                case TYPT_THREE_IMG:
                    mViewHolderThreeImg = (ViewHolderThreeImg) convertView.getTag();
                    break;

            }
        }

        //设置数据
        switch (type) {
            case TYPT_NO_IMG:
                mViewHolderNoImg.mTextView.setText(mDataBeanList.get(i).getTitle());
                break;
            case TYPT_ONE_IMG:
                mViewHolderOneImg.mTextView.setText(mDataBeanList.get(i).getTitle());
                ImageLoadHelper.loadImage(mContext, mViewHolderOneImg.mImageView, mDataBeanList.get(i).getThumbnail_pic_s());
                break;
            case TYPT_TWO_IMG:
                mViewHolderTwoImg.mTextView.setText(mDataBeanList.get(i).getTitle());
                ImageLoadHelper.loadImage(mContext, mViewHolderTwoImg.mImageView1, mDataBeanList.get(i).getThumbnail_pic_s());
                ImageLoadHelper.loadImage(mContext, mViewHolderTwoImg.mImageView2, mDataBeanList.get(i).getThumbnail_pic_s02());

                break;
            case TYPT_THREE_IMG:
                mViewHolderThreeImg.mTextView.setText(mDataBeanList.get(i).getTitle());
                ImageLoadHelper.loadImage(mContext, mViewHolderThreeImg.mImageView1, mDataBeanList.get(i).getThumbnail_pic_s());
                ImageLoadHelper.loadImage(mContext, mViewHolderThreeImg.mImageView2, mDataBeanList.get(i).getThumbnail_pic_s02());
                ImageLoadHelper.loadImage(mContext, mViewHolderThreeImg.mImageView3, mDataBeanList.get(i).getThumbnail_pic_s03());
                break;

        }


        return convertView;
    }


    class ViewHolderNoImg {
        private TextView mTextView;// 标题
    }

    class ViewHolderOneImg {
        private ImageView mImageView;//图片
        private TextView mTextView;// 标题
    }

    class ViewHolderTwoImg {
        private ImageView mImageView1;//图片1
        private ImageView mImageView2;//图片2
        private TextView mTextView;// 标题
    }

    class ViewHolderThreeImg {
        private ImageView mImageView1;//图片1
        private ImageView mImageView2;//图片2
        private ImageView mImageView3;//图片3
        private TextView mTextView;// 标题
    }
}
