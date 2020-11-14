package com.example.baseprojectandroid.src.page.introduce_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.src.adapter.introduce_adapter.IntroduceAdapter;

public class IntroduceActivity extends AppCompatActivity {
    private ViewPager mViewPager;

    //variable
    private IntroduceAdapter mIntroduceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        initView();
        init();
    }

    private void init() {
        mIntroduceAdapter = new IntroduceAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mIntroduceAdapter);
    }

    private void initView() {
        mViewPager = findViewById(R.id.viewpager_introduce);
    }
}