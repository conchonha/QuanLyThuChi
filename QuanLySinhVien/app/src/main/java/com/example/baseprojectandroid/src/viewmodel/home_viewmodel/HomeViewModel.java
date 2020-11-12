package com.example.baseprojectandroid.src.viewmodel.home_viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.onlineread.models.story_model.StoryModel;
import com.example.onlineread.src.repositories.home_repository.BannerRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<StoryModel>> arrayBanner;
    private BannerRepository bannerRepository;

    public void init(){
        if(arrayBanner != null){
            return;
        }
        bannerRepository = BannerRepository.getInstante();
        arrayBanner = bannerRepository.getListBanner();
    }

    public MutableLiveData<List<StoryModel>> getListBanner(){
        return arrayBanner;
    }

}
