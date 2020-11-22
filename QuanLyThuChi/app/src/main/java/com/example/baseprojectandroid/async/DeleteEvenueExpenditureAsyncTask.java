package com.example.baseprojectandroid.async;

import android.os.AsyncTask;

import com.example.baseprojectandroid.cores.room.dao.EevenueExpenditureDao;
import com.example.baseprojectandroid.cores.room.table.EevenueExpenditure;

public class DeleteEvenueExpenditureAsyncTask  extends AsyncTask<Void,Void,Void> {
    private EevenueExpenditure mEvenueExpenditure;
    private EevenueExpenditureDao mEvenueExpenditureDao;

    public DeleteEvenueExpenditureAsyncTask(EevenueExpenditure eevenueExpenditure, EevenueExpenditureDao eevenueExpenditureDao){
        this.mEvenueExpenditure = eevenueExpenditure;
        this.mEvenueExpenditureDao = eevenueExpenditureDao;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        mEvenueExpenditureDao.delete(mEvenueExpenditure);
        return null;
    }
}