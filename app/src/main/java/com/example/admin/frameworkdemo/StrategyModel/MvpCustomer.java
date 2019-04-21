package com.example.admin.frameworkdemo.StrategyModel;

import android.util.Log;

public class MvpCustomer implements IGetPrice {
    private final static String TAG = "StrategyModel";

    @Override
    public int getDiscountPrice(int originalPrice) {
        originalPrice = originalPrice*3;
        Log.d(TAG, "MVP客户翻两倍");
        return originalPrice;
    }
}
