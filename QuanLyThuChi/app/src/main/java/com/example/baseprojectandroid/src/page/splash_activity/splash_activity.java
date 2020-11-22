package com.example.baseprojectandroid.src.page.splash_activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.src.page.introduce_activity.IntroduceActivity;

public class splash_activity extends AppCompatActivity {
    //variable
    private Handler mHandler;
    private Runnable mRunable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        mHandler = new Handler();
        mRunable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), IntroduceActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                finish();
            }
        };
        mHandler.postDelayed(mRunable,3000);
    }

}