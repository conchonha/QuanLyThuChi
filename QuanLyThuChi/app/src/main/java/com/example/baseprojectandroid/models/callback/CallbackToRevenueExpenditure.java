package com.example.baseprojectandroid.models.callback;

import com.example.baseprojectandroid.cores.room.table.RevenueExpenditureTable;

public interface CallbackToRevenueExpenditure {
    public void getTimePickerDialog(String time);
    public void getTitleDialog(String title);
    public void getRevenueExpenditureObject(RevenueExpenditureTable revenueExpenditureTable);
}
