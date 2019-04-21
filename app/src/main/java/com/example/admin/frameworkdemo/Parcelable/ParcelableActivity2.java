package com.example.admin.frameworkdemo.Parcelable;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

public class ParcelableActivity2 extends Activity {
    private static final String TAG = "Parcelable";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Book book = (Book)getIntent().getParcelableExtra("info");
        Log.d(TAG, "bookName--->" + book.getBookName());
    }
}
