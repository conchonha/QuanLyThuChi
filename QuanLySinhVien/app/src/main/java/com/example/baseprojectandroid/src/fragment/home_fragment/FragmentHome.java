package com.example.baseprojectandroid.src.fragment.home_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.onlineread.R;
import com.example.onlineread.models.story_model.StoryModel;
import com.example.onlineread.src.adapter.home_adapter.BannerAdapter;
import com.example.onlineread.src.viewmodel.home_viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {
    private View mView;
    private ViewPager mVpHomePage;
    private HomeViewModel mHomeViewModel;
    private BannerAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);

        //khoi tao viewmodel
        mHomeViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
        mHomeViewModel.init();

        //Lắng nghe và trả về dữ liệu
        mHomeViewModel.getListBanner().observe(getViewLifecycleOwner(), new Observer<List<StoryModel>>() {
            @Override
            public void onChanged(List<StoryModel> storyModels) {
                mAdapter.notifyDataSetChanged();
            }
        });
        innitViewPager();
        return mView;

    }

    private void innitViewPager() {
        mVpHomePage = mView.findViewById(R.id.vpHomePage);
        mAdapter = new BannerAdapter((ArrayList) mHomeViewModel.getListBanner().getValue(), getActivity());
        mVpHomePage.setAdapter(mAdapter);
    }

}
