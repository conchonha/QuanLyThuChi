package com.example.baseprojectandroid.src.viewmodel.revenue_expenditure_viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baseprojectandroid.cores.room.table.EevenueExpenditure;
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

    public void insertEvenueExpenditure(EevenueExpenditure eevenueExpenditure){
        mRevenueExpenditureRepositories.insert(eevenueExpenditure);
    }

    public void updateEvenueExpenditure(EevenueExpenditure eevenueExpenditure){
        mRevenueExpenditureRepositories.update(eevenueExpenditure);
    }

    public void deleteEvenueExpenditure(EevenueExpenditure eevenueExpenditure){
        mRevenueExpenditureRepositories.delete(eevenueExpenditure);
    }

    public LiveData<List<EevenueExpenditure>> getAllListEvenueExpenditure(String type){
        return mRevenueExpenditureRepositories.getAllListEevenueExpenditure(type);
    }


}