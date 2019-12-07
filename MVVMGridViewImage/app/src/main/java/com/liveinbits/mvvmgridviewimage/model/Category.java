package com.liveinbits.mvvmgridviewimage.model;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String desc;
    @SerializedName("path")
    private String imagepath;

    public Category(){

    }

    public Category(String title, String desc, String imagepath) {
        this.title = title;
        this.desc = desc;
        this.imagepath = imagepath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
}
