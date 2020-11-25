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
import com.example.baseprojectandroid.utils.Constain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RevenueExpenditureViewmodel extends AndroidViewModel {
    private RevenueExpenditureRepositories mRevenueExpenditureRepositories;
    private MutableLiveData<List<RevenueExpenditureTable>>mListRevenueTable = new MutableLiveData<>();
    private MutableLiveData<List<RevenueExpenditureTable>>mListExpenditureTable = new MutableLiveData<>();
    private MutableLiveData<List<RevenueExpenditureTable>>mListAllRevenueExpenditureTable = new MutableLiveData<>();

    private List<SpinnerModel>mListSpinner = new ArrayList<>();
    private String TAG = "RevenueExpenditureViewmodel";
    private String mMounth;
    private String mYear;

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

    public LiveData<List<RevenueExpenditureTable>> getListRevenueExpenditure(String type){
        return mRevenueExpenditureRepositories.getListEevenueExpenditure(type);
    }

    public LiveData<List<RevenueExpenditureTable>>getAllListRevenueExpenditure(){
        return mRevenueExpenditureRepositories.getmListAllEevenueExpenditure();
    }


    //getter and setter
    public String getmMounth() {
        return mMounth;
    }

    public void setmMounth(String mMounth) {
        this.mMounth = mMounth;
    }

    public String getmYear() {
        return mYear;
    }

    public void setmYear(String mYear) {
        this.mYear = mYear;
    }

    public LiveData<List<RevenueExpenditureTable>> getmListRevenueTable(){
        return mListRevenueTable;
    }

    public LiveData<List<RevenueExpenditureTable>> getmListExpenditureTable(){
        return this.mListExpenditureTable;
    }

    public void setmListRevenueTable(List<RevenueExpenditureTable>list){
        mListRevenueTable.setValue(list);
        Log.d(TAG, "set list RevenueTable: "+mListRevenueTable.getValue().size());
    }

    public void setmListExpenditureTable(List<RevenueExpenditureTable>list){
        mListExpenditureTable.setValue(list);
        Log.d(TAG, "set list ExpenditureTable: "+mListExpenditureTable.getValue().size());
    }

    public void setmListSpinner(List<SpinnerModel>listSpinner){
        this.mListSpinner = listSpinner;
    }

    public void setmListAllRevenueExpenditureTable(List<RevenueExpenditureTable>list){
        this.mListAllRevenueExpenditureTable.setValue(list);
    }

    public LiveData<List<RevenueExpenditureTable>>getListAllRevenueExpenditureTable(){
        return this.mListAllRevenueExpenditureTable;
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


    //get list spinner mounth
    public LiveData<List<String>>getListMounthSpinner(){
        return mRevenueExpenditureRepositories.getListMounth();
    }

    //get list spinner year
    public LiveData<List<String>>getListYearthSpinner(){
        return mRevenueExpenditureRepositories.getListYear();
    }

    //get total all revenue expenditure
    public Map<String,String>getTotalAllStatistical(){
        int totalRevenue = 0;
        int totalExpenditure = 0;
        int totalSymmetrical = 0;
        for (RevenueExpenditureTable obj : getmListRevenueTable().getValue()) {
            totalRevenue += obj.getmPrice();
        }

        for (RevenueExpenditureTable obj : getmListExpenditureTable().getValue()) {
            totalExpenditure += obj.getmPrice();
        }

        totalSymmetrical = totalRevenue - totalExpenditure;
        Map<String,String>map = new HashMap<>();
        map.put(Constain.totalRevenue,totalRevenue+"");
        map.put(Constain.totalExpenditure,totalExpenditure+"");
        map.put(Constain.totalSymmetrical,totalSymmetrical+"");
        return map;
    }

    //get total mounth + year revenue expenditure
    public Map<String,String>getTotalMounthYearStatistical(){
        int totalRevenue = 0;
        int totalExpenditure = 0;
        int totalSymmetrical = 0;
        for (RevenueExpenditureTable obj : getmListRevenueTable().getValue()) {
            String []listTime = obj.getmCreateTime().split("-");
            if(listTime[0].equals(getmYear()) && listTime[1].equals(getmMounth())){
                totalRevenue += obj.getmPrice();
            }
        }

        for (RevenueExpenditureTable obj : getmListExpenditureTable().getValue()) {
            String []listTime = obj.getmCreateTime().split("-");
            if(listTime[0].equals(getmYear()) && listTime[1].equals(getmMounth())){
                totalExpenditure += obj.getmPrice();
            }
        }

        totalSymmetrical = totalRevenue - totalExpenditure;
        Map<String,String>map = new HashMap<>();
        map.put(Constain.totalRevenue,totalRevenue+"");
        map.put(Constain.totalExpenditure,totalExpenditure+"");
        map.put(Constain.totalSymmetrical,totalSymmetrical+"");
        return map;
    }
    //get total year revenue expenditure
    public Map<String,String>getTotalYearStatistical(){
        int totalRevenue = 0;
        int totalExpenditure = 0;
        int totalSymmetrical = 0;
        for (RevenueExpenditureTable obj : getmListRevenueTable().getValue()) {
            String []listTime = obj.getmCreateTime().split("-");
            if(listTime[0].equals(getmYear())){
                totalRevenue += obj.getmPrice();
            }
        }

        for (RevenueExpenditureTable obj : getmListExpenditureTable().getValue()) {
            String []listTime = obj.getmCreateTime().split("-");
            if(listTime[0].equals(getmYear())){
                totalExpenditure += obj.getmPrice();
            }
        }

        totalSymmetrical = totalRevenue - totalExpenditure;
        Map<String,String>map = new HashMap<>();
        map.put(Constain.totalRevenue,totalRevenue+"");
        map.put(Constain.totalExpenditure,totalExpenditure+"");
        map.put(Constain.totalSymmetrical,totalSymmetrical+"");
        return map;
    }
}
