package com.example.baseprojectandroid.cores.room.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.example.baseprojectandroid.cores.room.BaseObject;

@Entity(tableName = "EevenueExpenditure")
public class EevenueExpenditure extends BaseObject {
    @ColumnInfo(name = "title")
    public String mTitle;

    @ColumnInfo(name = "price")
    public int mPrice;

    @ColumnInfo(name = "type")
    public String mType;

    @ColumnInfo(name = "content")
    public String mContent;

    /*
     * Constructer
     */

    public EevenueExpenditure() {

    }

    public EevenueExpenditure(String type, String title, int price, String content, String createTime, String updateTime) {
        super(createTime, updateTime);
        this.mType = type;
        this.mTitle = title;
        this.mPrice = price;
        this.mContent = content;
    }

    /*
     * Getters and Setters
     */

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }
}