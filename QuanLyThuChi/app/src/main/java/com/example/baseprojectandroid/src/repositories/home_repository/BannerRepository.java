//package com.example.baseprojectandroid.src.repositories.home_repository;
//
//import androidx.lifecycle.MutableLiveData;
//
//import com.example.onlineread.models.story_model.StoryModel;
//
//import java.util.ArrayList;
//import java.util.List;
//
////làm việc vs webserver
//public class BannerRepository {
//    private List<StoryModel>mArrayBanner = new ArrayList<>();
//    private static BannerRepository instante;
//
//    // Khởi tạo BannerRepository
//    public static BannerRepository getInstante(){
//        if(instante == null){
//            instante = new BannerRepository();
//        }
//        return instante;
//    }
//    // Quan sát & lắng nghe dữ liệu
//    public MutableLiveData<List<StoryModel>> getListBanner(){
//        MutableLiveData<List<StoryModel>>arrayTmp = new MutableLiveData<>();
//        setDataArrayBanner();
//        arrayTmp.setValue(mArrayBanner);
//        return arrayTmp;
//    }
//    //Tạo dữ liệu ảo
//    private void setDataArrayBanner(){
//        for (int i = 0; i <= 7; i++){
//            StoryModel model = new StoryModel();
//            model.setmImage("https://www.imgacademy.com/themes/custom/imgacademy/images/helpbox-contact.jpg");
//            mArrayBanner.add(model);
//        }
//    }
//}
