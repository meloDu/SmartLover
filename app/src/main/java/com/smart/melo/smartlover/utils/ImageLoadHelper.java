package com.smart.melo.smartlover.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageLoadHelper {

    private ImageLoadHelper() {
    }

    public static void loadImage(final Context context, final ImageView imageView, final String imageUrl) {
                Picasso.with(context).load(AppUtils.getScaledImageUrl(imageUrl, imageView.getMeasuredWidth(), imageView.getMeasuredHeight())).into(imageView);
    }

    public static void loadImage(final Context context, final ImageView imageView, final String imageUrl, final int defaultImgId) {
                Picasso.with(context).load(AppUtils.getScaledImageUrl(imageUrl, imageView.getMeasuredWidth(), imageView.getMeasuredHeight())).placeholder(defaultImgId).into(imageView);
    }

}
