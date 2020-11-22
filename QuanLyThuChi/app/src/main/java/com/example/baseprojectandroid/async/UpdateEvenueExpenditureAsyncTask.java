package com.example.baseprojectandroid.async;

import android.os.AsyncTask;

import com.example.baseprojectandroid.cores.room.dao.EevenueExpenditureDao;
import com.example.baseprojectandroid.cores.room.table.EevenueExpenditure;

public class UpdateEvenueExpenditureAsyncTask extends AsyncTask<Void,Void,Void> {
    private EevenueExpenditure mEvenueExpenditure;
    private EevenueExpenditureDao mEvenueExpenditureDao;

    public UpdateEvenueExpenditureAsyncTask(EevenueExpenditure eevenueExpenditure, EevenueExpenditureDao eevenueExpenditureDao){
        this.mEvenueExpenditure = eevenueExpenditure;
        this.mEvenueExpenditureDao = eevenueExpenditureDao;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        mEvenueExpenditureDao.update(mEvenueExpenditure);
        return null;
    }
}
