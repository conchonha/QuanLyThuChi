package com.example.baseprojectandroid.src.adapter.home_adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.onlineread.R;
import com.example.onlineread.models.story_model.StoryModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    private ArrayList<StoryModel>mArrayBanner;
    private Context mContext;
    private View mView;


    public BannerAdapter(ArrayList<StoryModel>mArrayBanner, Context mContext) {
        this.mArrayBanner = mArrayBanner;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        mView = View.inflate(mContext, R.layout.layout_item_banner,null);

        ImageView mImageView = mView.findViewById(R.id.img_bannerHome);
        Picasso.with(mContext).load(mArrayBanner.get(position).getmImage()).into(mImageView);
        container.addView(mView);
        return mView;
    }

    @Override
    //dem so luongrepos
    public int getCount() {
        return mArrayBanner.size();
    }

    @Override
    //chuyen doi oject thanh view
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
