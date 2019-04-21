package com.example.admin.frameworkdemo.DataBinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class User {
    private String name;
    private int age;
    private String phone;
    private String imgUrl;
    //0男 1女
    private int gender;

    public User(String name, int age, String phone,String imgUrl) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.imgUrl = imgUrl;
    }

    @BindingAdapter({"imgUrl"})
    public static void loadImage(ImageView imageView, String imgUrl){
        //必须为static方法，否则报错
        Glide.with(imageView.getContext()).load(imgUrl).into(imageView);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}