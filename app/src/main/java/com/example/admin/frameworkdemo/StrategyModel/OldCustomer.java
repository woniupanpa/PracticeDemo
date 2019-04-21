package com.example.admin.frameworkdemo.StrategyModel;

import android.util.Log;

public class OldCustomer implements IGetPrice {
    private final static String TAG = "StrategyModel";
    @Override
    public int getDiscountPrice(int originalPrice) {
        originalPrice = originalPrice*2;
        Log.d(TAG, "老客户翻一倍");
        return originalPrice;
    }
}
