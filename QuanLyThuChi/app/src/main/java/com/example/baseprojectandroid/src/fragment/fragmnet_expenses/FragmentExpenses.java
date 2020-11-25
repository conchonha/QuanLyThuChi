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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.compoments.ItemTouchHelperSimpleCallback;
import com.example.baseprojectandroid.cores.room.table.RevenueExpenditureTable;
import com.example.baseprojectandroid.models.callback.CallbackToRevenueExpenditure;
import com.example.baseprojectandroid.src.adapter.revenue_expenditure_adapter.RevenueExpenditureAdapter;
import com.example.baseprojectandroid.src.dialog.FragmentDialogRevenueExpenditure;
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
    private FragmentDialogRevenueExpenditure mFragmentDialogAddRevenueExpenditure;
    private String TAG = "FragmentExpenses";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_expenses, container, false);
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
        mRecyclerViewExpenses.setLayoutManager(new GridLayoutManager(mView.getContext(), 1));

        //khởi tạo adapter
        mAdapter = new RevenueExpenditureAdapter(getFragmentManager());
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(ItemTouchHelperSimpleCallback.simpleCallBack(FragmentExpenses.this,getString(R.string.lbl_expenses),mRevenueExpenditureViewmodel,getActivity(),mRecyclerViewExpenses));
        itemTouchHelper.attachToRecyclerView(mRecyclerViewExpenses);
        mRecyclerViewExpenses.setAdapter(mAdapter);
    }

    //khởi tạo viewmodel
    private void intViewModel() {
        mRevenueExpenditureViewmodel = ViewModelProviders.of(getActivity()).get(RevenueExpenditureViewmodel.class);

        //quan sát và lắng nghe sự thay đổi của dữ liệu
        mRevenueExpenditureViewmodel.getListRevenueExpenditure(getString(R.string.lbl_expenses)).observe(getViewLifecycleOwner(), new Observer<List<RevenueExpenditureTable>>() {
            @Override
            public void onChanged(List<RevenueExpenditureTable> revenueExpenditureTables) {
                mAdapter.setListEvenueExpenditure(revenueExpenditureTables);
                mAdapter.notifyDataSetChanged();
                mRevenueExpenditureViewmodel.setmListExpenditureTable(revenueExpenditureTables);
            }
        });

    }

    //lắng nghe sự kiện onclick view
    private void listenerOnclickedView() {
        mFabExpenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentDialogAddRevenueExpenditure = new FragmentDialogRevenueExpenditure();
                CallbackToRevenueExpenditure callbackToRevenueExpenditure = mFragmentDialogAddRevenueExpenditure;
                callbackToRevenueExpenditure.getTitleDialog(getString(R.string.lbl_expenses));
                mFragmentDialogAddRevenueExpenditure.setCancelable(false);
                mFragmentDialogAddRevenueExpenditure.show(getFragmentManager(), Constain.fragmentDialogRevenueExpenditure);
            }
        });
    }
}
