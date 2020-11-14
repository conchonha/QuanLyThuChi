package com.example.baseprojectandroid.src.adapter.tabbar_adapter;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.src.fragment.fragment_revenue.FragmentRevenue;
import com.example.baseprojectandroid.src.fragment.fragment_statistical.FragmentStatistical;
import com.example.baseprojectandroid.src.fragment.fragmnet_expenses.FragmentExpenses;

import java.util.ArrayList;
import java.util.List;

public class TabbarAdapter extends FragmentStatePagerAdapter {
    private List<String>mListTitle = new ArrayList<>();
    private List<Fragment>mListFragment = new ArrayList<>();

    public TabbarAdapter(@NonNull FragmentManager fm, Activity activity) {
        super(fm);
        //add title tabbar
        mListTitle.add(activity.getResources().getString(R.string.lbl_revenue));
        mListTitle.add(activity.getResources().getString(R.string.lbl_expenses));
        mListTitle.add(activity.getResources().getString(R.string.lbl_statistical));

        //add fragment tuong ứng
        mListFragment.add(new FragmentRevenue());
        mListFragment.add(new FragmentStatistical());
        mListFragment.add(new FragmentExpenses());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mListFragment.get(position);
    }

    @Override
    public int getCount() {
        return mListFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mListTitle.get(position);
    }
}
