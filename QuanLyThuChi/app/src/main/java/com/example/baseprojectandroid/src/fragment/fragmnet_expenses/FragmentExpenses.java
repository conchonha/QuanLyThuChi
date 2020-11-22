package com.example.baseprojectandroid.src.fragment.fragmnet_expenses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.cores.room.table.RevenueExpenditureTable;
import com.example.baseprojectandroid.models.callback.CallbackToDate;
import com.example.baseprojectandroid.src.adapter.revenue_expenditure_adapter.RevenueExpenditureAdapter;
import com.example.baseprojectandroid.src.dialog.fragment_dialog_add.FragmentDialogAddRevenue;
import com.example.baseprojectandroid.src.viewmodel.revenue_expenditure_viewmodel.RevenueExpenditureViewmodel;
import com.example.baseprojectandroid.utils.Constain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class FragmentExpenses extends Fragment {
    private View mView;
    private RecyclerView mRecyclerViewExpenses;
    private FloatingActionButton mFabExpenses;

    //variable
    private RevenueExpenditureAdapter mAdapter;
    private RevenueExpenditureViewmodel mRevenueExpenditureViewmodel;
    private FragmentDialogAddRevenue mFragmentDialogAddRevenue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_expenses,container,false);
        intViewModel();
        initView();
        init();
        listenerOnclickedView();
        return mView;
    }

    // ánh xạ view
    private void initView() {
        mRecyclerViewExpenses = mView.findViewById(R.id.recyclerview_expenses);
        mFabExpenses = mView.findViewById(R.id.fab_expenses);
    }

    private void init() {
        //khởi tạo recyclerview
        mRecyclerViewExpenses.setHasFixedSize(true);
        mRecyclerViewExpenses.setLayoutManager(new LinearLayoutManager(mView.getContext()));

        mAdapter = new RevenueExpenditureAdapter();
        mRecyclerViewExpenses.setAdapter(mAdapter);
    }

    //khởi tạo viewmodel
    private void intViewModel() {
        mRevenueExpenditureViewmodel = ViewModelProviders.of(getActivity()).get(RevenueExpenditureViewmodel.class);

        //quan sát và lắng nghe sự thay đổi của dữ liệu
        mRevenueExpenditureViewmodel.getAllListRevenueExpenditure(getString(R.string.lbl_expenses)).observe(getViewLifecycleOwner(), new Observer<List<RevenueExpenditureTable>>() {
            @Override
            public void onChanged(List<RevenueExpenditureTable> revenueExpenditureTables) {
                mAdapter.setListEvenueExpenditure(revenueExpenditureTables);
            }
        });
    }

    //lắng nghe sự kiện onclick view
    private void listenerOnclickedView() {
        mFabExpenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentDialogAddRevenue = new FragmentDialogAddRevenue();
                CallbackToDate callbackToDate = mFragmentDialogAddRevenue;
                callbackToDate.getTitleDialog(getString(R.string.lbl_expenses));
                mFragmentDialogAddRevenue.setCancelable(false);
                mFragmentDialogAddRevenue.show(getFragmentManager(), Constain.fragmentDialogRevenue);
            }
        });
    }
}
