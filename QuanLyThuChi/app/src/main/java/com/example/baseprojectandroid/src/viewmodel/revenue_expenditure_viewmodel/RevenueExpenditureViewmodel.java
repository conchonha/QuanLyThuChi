package com.example.baseprojectandroid.src.viewmodel.revenue_expenditure_viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.baseprojectandroid.cores.room.table.RevenueExpenditureTable;
import com.example.baseprojectandroid.models.spinner_model.SpinnerModel;
import com.example.baseprojectandroid.src.repositories.revenue_expenditure_repositories.RevenueExpenditureRepositories;

import java.util.ArrayList;
import java.util.List;

public class RevenueExpenditureViewmodel extends AndroidViewModel {
    private RevenueExpenditureRepositories mRevenueExpenditureRepositories;
    private MutableLiveData<List<RevenueExpenditureTable>>mListRevenueTable = new MutableLiveData<>();
    private MutableLiveData<List<RevenueExpenditureTable>>mListExpenditureTable = new MutableLiveData<>();
    private List<SpinnerModel>mListSpinner = new ArrayList<>();
    private String TAG = "RevenueExpenditureViewmodel";

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

    //get List RevenueTable
    public LiveData<List<RevenueExpenditureTable>> getmListRevenueTable(){
        return mListRevenueTable;
    }

    //get List Expenditure Table
    public LiveData<List<RevenueExpenditureTable>> getmListExpenditureTable(){
        return this.mListExpenditureTable;
    }

    //get index spinner
    public int getIndexSpinner(String content){
        int index = 0;
        if(mListSpinner != null){
            for (int i = 0; i < mListSpinner.size(); i++){
                if(mListSpinner.get(i).getmContent().equals(content)){
                    index = i;
                }
            }
        }
        return index;
    }

    //set list RevenueTable
    public void setmListRevenueTable(List<RevenueExpenditureTable>list){
        mListRevenueTable.setValue(list);
        Log.d(TAG, "set list RevenueTable: "+mListRevenueTable.getValue().size());
    }

    //set list ExpenditureTable
    public void setmListExpenditureTable(List<RevenueExpenditureTable>list){
        mListExpenditureTable.setValue(list);
        Log.d(TAG, "set list ExpenditureTable: "+mListExpenditureTable.getValue().size());
    }

    //set list spinner
    public void setmListSpinner(List<SpinnerModel>listSpinner){
        this.mListSpinner = listSpinner;
    }
}
