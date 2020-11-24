package com.example.baseprojectandroid.src.fragment.fragment_statistical;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.baseprojectandroid.R;
import com.google.android.material.tabs.TabLayout;

public class FragmentStatistical extends Fragment {
    private View mView;
    private TextView mTxtTotalRevenue,mTxtTotalExpendises;
    private TabLayout mTabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_statistical,container,false);
        initView();
        listenerOnclicked();
        return mView;
    }

    private void listenerOnclicked() {
    }

    private void initView() {
        mTxtTotalRevenue = mView.findViewById(R.id.txt_total_revenue);
        mTxtTotalExpendises = mView.findViewById(R.id.txt_total_expenses);
        mTabLayout = mView.findViewById(R.id.tab_layout);
    }
}
