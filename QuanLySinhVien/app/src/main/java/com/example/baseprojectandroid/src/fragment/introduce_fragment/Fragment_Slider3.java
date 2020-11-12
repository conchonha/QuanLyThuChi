package com.example.baseprojectandroid.src.fragment.introduce_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.src.page.login_activity.LoginActivity;


public class Fragment_Slider3 extends Fragment {
    private View mView;
    private Button mBtnGetStar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(R.layout.fragment_slider3,container,false);
        initView();
        listenerOnclickedView();
        return mView;
    }

    private void listenerOnclickedView() {
        mBtnGetStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                getActivity().finish();
            }
        });
    }

    private void initView() {
        mBtnGetStar = mView.findViewById(R.id.btn_get_started);
    }

}
