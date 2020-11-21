package com.example.baseprojectandroid.src.fragment.fragment_revenue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.src.dialog.fragment_dialog_add.FragmentDialogAddRevenue;
import com.example.baseprojectandroid.src.fragment.fragment_statistical.FragmentStatistical;
import com.example.baseprojectandroid.utils.Constain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FragmentRevenue extends Fragment {
    private View mView;
    private FloatingActionButton mFabRevenue;
    private FragmentDialogAddRevenue mFragmentDialogAddRevenue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_revenue,container,false);
        initView();
        listenerOnclickedView();
        return mView;
    }

    //lắng nghe sự kiện onclick view
    private void listenerOnclickedView() {
        mFabRevenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentDialogAddRevenue   = new FragmentDialogAddRevenue();
                mFragmentDialogAddRevenue.setCancelable(false);
                mFragmentDialogAddRevenue.show(getFragmentManager(), Constain.fragmentDialogRevenue);
            }
        });
    }

    //ánh xạ view
    private void initView() {
        mFabRevenue = mView.findViewById(R.id.fab_revenue);
    }
}
