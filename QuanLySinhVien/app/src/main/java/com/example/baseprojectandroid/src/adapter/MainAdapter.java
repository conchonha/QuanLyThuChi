package com.example.baseprojectandroid.src.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.onlineread.src.fragment.bookcase_fragment.FragmentBookcase;
import com.example.onlineread.src.fragment.classify_fragment.FragmentClassify;
import com.example.onlineread.src.fragment.discover_fragment.FragmentDiscover;
import com.example.onlineread.src.fragment.home_fragment.FragmentHome;
import com.example.onlineread.src.fragment.personal_fragment.FragmentPersonal;

import java.util.ArrayList;

public class MainAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment>arrayListFragment = new ArrayList<>();
    private ArrayList<String>arrayListTitle = new ArrayList<>();

    public MainAdapter(@NonNull FragmentManager fm) {
        super(fm);
        FragmentHome fragmentHome = new FragmentHome();
        arrayListFragment.add(fragmentHome);
        arrayListTitle.add("Trang Chủ");
        arrayListFragment.add(new FragmentClassify());
        arrayListTitle.add("Phân Loại");
        arrayListFragment.add(new FragmentDiscover());
        arrayListTitle.add("Khám Phá");
        arrayListFragment.add(new FragmentBookcase());
        arrayListTitle.add("Tủ Sách");
        arrayListFragment.add(new FragmentPersonal());
        arrayListTitle.add("Cá Nhân");
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arrayListFragment.get(position);
    }
    //lấy vị trí

    @Override
    public int getCount() {
        return arrayListFragment.size();
    }
    //đếm số lượng tab

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrayListTitle.get(position);
    }
}
