package com.example.baseprojectandroid.models.spinner_model;

public class SpinnerModel {
    private String mImageIcon;
    private String mContent;

    public SpinnerModel(String mImageIcon, String mContent) {
        this.mImageIcon = mImageIcon;
        this.mContent = mContent;
    }

    public String getmImageIcon() {
        return mImageIcon;
    }

    public void setmImageIcon(String mImageIcon) {
        this.mImageIcon = mImageIcon;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }
}
