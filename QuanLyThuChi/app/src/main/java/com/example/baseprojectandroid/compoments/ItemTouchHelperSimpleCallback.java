package com.example.baseprojectandroid.compoments;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.cores.room.table.RevenueExpenditureTable;
import com.example.baseprojectandroid.src.viewmodel.revenue_expenditure_viewmodel.RevenueExpenditureViewmodel;
import com.example.baseprojectandroid.utils.Helpers;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ItemTouchHelperSimpleCallback{
    public static ItemTouchHelper.SimpleCallback simpleCallBack(final List<RevenueExpenditureTable>list,final RevenueExpenditureViewmodel revenueExpenditureViewmodel, final Activity activity, final RecyclerView recyclerView){
        ItemTouchHelper.SimpleCallback simpleCallback1 = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int direction) {
                final RevenueExpenditureTable revenueExpenditureTable;
                switch (direction){
                    case ItemTouchHelper.LEFT:
                        revenueExpenditureTable = list.get(viewHolder.getAdapterPosition()-1);
                        final Dialog dialog = Helpers.showLoadingDialog(activity);
                        dialog.show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                revenueExpenditureViewmodel.deleteEvenueExpenditure(revenueExpenditureTable);
                                dialog.dismiss();
                                Snackbar.make(recyclerView,revenueExpenditureTable.getmContent(),Snackbar.LENGTH_LONG)
                                        .setAction(activity.getString(R.string.lbl_under), new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                dialog.show();
                                                new Handler().postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        revenueExpenditureViewmodel.insertEvenueExpenditure(revenueExpenditureTable);
                                                        dialog.dismiss();
                                                    }
                                                },3000);
                                            }
                                        }).show();
                            }
                        },3000);
                        break;
                    case  ItemTouchHelper.RIGHT:
                        break;
                }
            }
        };
        return simpleCallback1;
    }
}
