package com.example.baseprojectandroid.src.viewmodel.revenue_expenditure_viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.baseprojectandroid.cores.room.table.RevenueExpenditureTable;
import com.example.baseprojectandroid.models.spinner_model.SpinnerModel;
import com.example.baseprojectandroid.src.repositories.revenue_expenditure_repositories.RevenueExpenditureRepositories;

import java.util.List;

public class RevenueExpenditureViewmodel extends AndroidViewModel {
    private RevenueExpenditureRepositories mRevenueExpenditureRepositories;

    public RevenueExpenditureViewmodel(@NonNull Application application) {
        super(application);
        if(mRevenueExpenditureRepositories == null){
            mRevenueExpenditureRepositories = new RevenueExpenditureRepositories(application);
        }
    }

    public LiveData<List<SpinnerModel>> getListSpinner(){
        return mRevenueExpenditureRepositories.getListSpiner();
    }

    public void insertEvenueExpenditure(RevenueExpenditureTable revenueExpenditureTable){
        mRevenueExpenditureRepositories.insert(revenueExpenditureTable);
    }

    public void updateEvenueExpenditure(RevenueExpenditureTable revenueExpenditureTable){
        mRevenueExpenditureRepositories.update(revenueExpenditureTable);
    }

    public void deleteEvenueExpenditure(RevenueExpenditureTable revenueExpenditureTable){
        mRevenueExpenditureRepositories.delete(revenueExpenditureTable);
    }

    public LiveData<List<RevenueExpenditureTable>> getAllListRevenueExpenditure(String type){
        return mRevenueExpenditureRepositories.getAllListEevenueExpenditure(type);
    }


}
