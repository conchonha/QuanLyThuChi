package com.example.baseprojectandroid.src.adapter.introduce_adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.baseprojectandroid.src.fragment.introduce_fragment.Fragment_Slider1;
import com.example.baseprojectandroid.src.fragment.introduce_fragment.Fragment_Slider2;
import com.example.baseprojectandroid.src.fragment.introduce_fragment.Fragment_Slider3;

import java.util.ArrayList;

public class IntroduceAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrayFragment = new ArrayList<>();

    public IntroduceAdapter(@NonNull FragmentManager fm) {
        super(fm);
        arrayFragment.add(new Fragment_Slider1());
        arrayFragment.add(new Fragment_Slider2());
        arrayFragment.add(new Fragment_Slider3());
    }

    @Override
    public Fragment getItem(int position) {
        return arrayFragment.get(position);
    }

    @Override
    public int getCount() {
        return arrayFragment.size();
    }

}
