package com.example.baseprojectandroid.src.fragment.fragment_revenue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.cores.room.table.RevenueExpenditureTable;
import com.example.baseprojectandroid.models.callback.CallbackToRevenueExpenditure;
import com.example.baseprojectandroid.src.adapter.revenue_expenditure_adapter.RevenueExpenditureAdapter;
import com.example.baseprojectandroid.src.dialog.FragmentDialogRevenueExpenditure;
import com.example.baseprojectandroid.src.viewmodel.revenue_expenditure_viewmodel.RevenueExpenditureViewmodel;
import com.example.baseprojectandroid.utils.Constain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class FragmentRevenue extends Fragment {
    private View mView;
    private FloatingActionButton mFabRevenue;
    private RecyclerView mRecyclerViewRevenue;

    //variable
    private FragmentDialogRevenueExpenditure mFragmentDialogAddRevenueExpenditure;
    private RevenueExpenditureViewmodel mRevenueExpenditureViewmodel;
    private RevenueExpenditureAdapter mAdapter;
    private String TAG = "FragmentRevenue";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_revenue,container,false);
        intViewModel();
        initView();
        init();
        listenerOnclickedView();
        return mView;
    }

    private void init() {
        //khởi tạo recyclerview
        mRecyclerViewRevenue.setHasFixedSize(true);
        mRecyclerViewRevenue.setLayoutManager(new GridLayoutManager(getContext(),1));

        mAdapter = new RevenueExpenditureAdapter(getFragmentManager());
        mRecyclerViewRevenue.setAdapter(mAdapter);
    }

    //khởi tạo viewmodel
    private void intViewModel() {
        mRevenueExpenditureViewmodel = ViewModelProviders.of(getActivity()).get(RevenueExpenditureViewmodel.class);

        //quan sát và lắng nghe sự thay đổi của dữ liệu
        mRevenueExpenditureViewmodel.getAllListRevenueExpenditure(getString(R.string.lbl_revenue)).observe(getViewLifecycleOwner(), new Observer<List<RevenueExpenditureTable>>() {
            @Override
            public void onChanged(List<RevenueExpenditureTable> revenueExpenditureTables) {
                mAdapter.setListEvenueExpenditure(revenueExpenditureTables);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    //lắng nghe sự kiện onclick view
    private void listenerOnclickedView() {
        mFabRevenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentDialogAddRevenueExpenditure = new FragmentDialogRevenueExpenditure();
                CallbackToRevenueExpenditure callbackToRevenueExpenditure = mFragmentDialogAddRevenueExpenditure;
                callbackToRevenueExpenditure.getTitleDialog(getString(R.string.lbl_revenue));
                mFragmentDialogAddRevenueExpenditure.setCancelable(false);
                mFragmentDialogAddRevenueExpenditure.show(getFragmentManager(), Constain.fragmentDialogRevenueExpenditure);
            }
        });
    }

    //ánh xạ view
    private void initView() {
        mFabRevenue = mView.findViewById(R.id.fab_revenue);
        mRecyclerViewRevenue = mView.findViewById(R.id.recyclerview_revenue);
    }
}
