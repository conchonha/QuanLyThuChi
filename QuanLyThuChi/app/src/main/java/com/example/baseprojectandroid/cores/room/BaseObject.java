package com.example.baseprojectandroid.cores.room;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import com.example.baseprojectandroid.utils.Helpers;

import java.util.Calendar;

public class BaseObject {
    @PrimaryKey(autoGenerate = true)
    public int mId;

    @ColumnInfo(name = "create_time")
    public String mCreateTime;

    @ColumnInfo(name = "update_time")
    public String mUpdateTime;

    //constructer defaul
    public BaseObject(){

    }

    //contructer parameter
    public BaseObject(String createTime,String updateTime){
        if(createTime == null){
            this.mCreateTime = Helpers.getTime();
        }else {
            this.mCreateTime = createTime;
            this.mUpdateTime = updateTime;
        }
    }

    //getter and setter
    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmCreateTime() {
        return mCreateTime;
    }

    public void setmCreateTime(String mCreateTime) {
        this.mCreateTime = mCreateTime;
    }

    public String getmUpdateTime() {
        return mUpdateTime;
    }

    public void setmUpdateTime(String mUpdateTime) {
        this.mUpdateTime = mUpdateTime;
    }
}
