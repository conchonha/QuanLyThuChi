package com.example.baseprojectandroid.src.viewmodel.revenue_viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baseprojectandroid.models.spinner_model.SpinnerModel;
import com.example.baseprojectandroid.src.repositories.spinner_repositories.SpinnerRepositories;

import java.util.List;

public class RevenueViewmodel extends ViewModel {
    private SpinnerRepositories mSpinnerRepositories;
    private MutableLiveData<List<SpinnerModel>>mListMutableLiveDataSpinner;

    public void initListSpinner(){
        if(mListMutableLiveDataSpinner == null){
            mSpinnerRepositories = SpinnerRepositories.getInstance();
            mListMutableLiveDataSpinner = mSpinnerRepositories.getListSpiner();
        }
    }

    public LiveData<List<SpinnerModel>> getListSpinner(){
        return this.mListMutableLiveDataSpinner;
    }

}
