package com.example.baseprojectandroid.async;

import android.os.AsyncTask;

import com.example.baseprojectandroid.cores.room.dao.EevenueExpenditureDao;
import com.example.baseprojectandroid.cores.room.table.RevenueExpenditureTable;

public class UpdateEvenueExpenditureAsyncTask extends AsyncTask<Void,Void,Void> {
    private RevenueExpenditureTable mEvenueExpenditure;
    private EevenueExpenditureDao mEvenueExpenditureDao;

    public UpdateEvenueExpenditureAsyncTask(RevenueExpenditureTable revenueExpenditureTable, EevenueExpenditureDao eevenueExpenditureDao){
        this.mEvenueExpenditure = revenueExpenditureTable;
        this.mEvenueExpenditureDao = eevenueExpenditureDao;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        mEvenueExpenditureDao.update(mEvenueExpenditure);
        return null;
    }
}
