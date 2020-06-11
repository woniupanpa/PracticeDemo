package com.example.admin.frameworkdemo.DataBinding;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.admin.frameworkdemo.BR;
import com.example.admin.frameworkdemo.R;
import com.kelin.mvvmlight.command.ReplyCommand;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class User {
    private static final String TAG = "DataBinding";
    private String name;
    private int age;
    private String phone;
    private String imgUrl;
    //0男 1女
    private int gender;

    public final ObservableList<String> student = new ObservableArrayList<>();
    public final ItemBinding<String> stringItemBinding = ItemBinding.of(BR.item, R.layout.activity_item_binding);

    public User(String name, int age, String phone,String imgUrl) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.imgUrl = imgUrl;
        student.add("Machael");
        student.add("Kobe");
        student.add("Harden");
        student.add("Curry");
        student.add("Durrant");
        student.add("Paul");
    }

    public final ReplyCommand<Integer> onItemSelected = new ReplyCommand<>(index -> {
            Log.d(TAG, "index--->" + index);
    });

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