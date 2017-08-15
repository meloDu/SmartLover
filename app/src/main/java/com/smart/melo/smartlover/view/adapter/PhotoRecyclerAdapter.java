package com.smart.melo.smartlover.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.bean.PhotoBean;
import com.smart.melo.smartlover.utils.ImageLoadHelper;

import java.util.List;

/**
 * Created by melo on 2017/8/15.
 */
public class PhotoRecyclerAdapter extends RecyclerView.Adapter<PhotoRecyclerAdapter.ViewHolder> {

    private List<PhotoBean.ResultsBean> photoList;
    private Context context;



    public interface ItemClickListener {
        void onLayoutListener(View view, int position);
    }

    private ItemClickListener listener;

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public PhotoRecyclerAdapter(Context context, List<PhotoBean.ResultsBean> photoList) {
        this.context = context;
        this.photoList = photoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fragment_photorv, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String imageUrl = photoList.get(position).getUrl();
        ImageLoadHelper.loadImage(context, holder.mImageView, imageUrl, R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return photoList != null ? photoList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        RelativeLayout mLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_photorv);
            mLayout = (RelativeLayout) itemView.findViewById(R.id.layout_photorv);

            mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onLayoutListener(v, getLayoutPosition());
                    }
                }
            });
        }
    }
}
