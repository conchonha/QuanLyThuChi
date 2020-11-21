package com.example.baseprojectandroid.src.repositories.spinner_repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.baseprojectandroid.models.spinner_model.SpinnerModel;

import java.util.ArrayList;
import java.util.List;

public class SpinnerRepositories {
    public static SpinnerRepositories mInstanceSpinnerRepositories;
    private List<SpinnerModel> mListSpiner = new ArrayList<>();

    public static SpinnerRepositories getInstance(){
        if(mInstanceSpinnerRepositories == null){
            mInstanceSpinnerRepositories = new SpinnerRepositories();
        }
        return mInstanceSpinnerRepositories;
    }

    public MutableLiveData<List<SpinnerModel>> getListSpiner(){
        MutableLiveData<List<SpinnerModel>>listTmt = new MutableLiveData<>();
        addData();
        listTmt.setValue(mListSpiner);
        return listTmt;
    }

    private void addData() {
        mListSpiner.clear();
        mListSpiner.add(new SpinnerModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS10aPi7W9xsHqOq2g3orJHs-9DaRv9UgQYlQ&usqp=CAU","Khác"));
        mListSpiner.add(new SpinnerModel("https://e7.pngegg.com/pngimages/1004/46/png-clipart-real-estate-building-property-house-business-office-building-angle-building.png","Cho thuê nhà"));
        mListSpiner.add(new SpinnerModel("https://www.vhv.rs/dpng/d/440-4409798_gift-vector-icon-icon-gift-vector-png-transparent.png","Quà tặng"));
        mListSpiner.add(new SpinnerModel("https://e7.pngegg.com/pngimages/396/516/png-clipart-computer-icons-commerce-discount-icon-logo-desktop-wallpaper.png","Trợ cấp"));
        mListSpiner.add(new SpinnerModel("https://w7.pngwing.com/pngs/824/347/png-transparent-computer-icons-black-and-white-graphic-design-teamwork-icon-text-photography-logo.png","Việc làm"));
        mListSpiner.add(new SpinnerModel("https://img95.699pic.com/element/40137/9272.png_300.png","Buôn bán"));
        mListSpiner.add(new SpinnerModel("https://www.pngfind.com/pngs/m/140-1407971_back-payment-payment-icon-png-transparent-png-download.png","Thu nhập chính"));
        mListSpiner.add(new SpinnerModel("https://cdn.iconscout.com/icon/premium/png-512-thumb/money-raise-986677.png","Lãi suất"));
    }
}
