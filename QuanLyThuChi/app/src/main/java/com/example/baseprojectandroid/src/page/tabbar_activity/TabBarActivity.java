package com.example.baseprojectandroid.src.page.tabbar_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.src.adapter.tabbar_adapter.TabbarAdapter;
import com.google.android.material.tabs.TabLayout;

public class TabBarActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    //variable
    private TabbarAdapter mTabbarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbar);
        initView();
        init();
    }

    private void init() {
        mTabbarAdapter = new TabbarAdapter(getSupportFragmentManager(),TabBarActivity.this);

        //set adapter cho viewpager
        mViewPager.setAdapter(mTabbarAdapter);

        //set icon cho tablayout
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_revenue);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_expenses);
        mTabLayout.getTabAt(2).setIcon(R.drawable.ic_statistical);
    }

    //ánh xạ view
    private void initView() {
        mViewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tab_layout);
    }
}