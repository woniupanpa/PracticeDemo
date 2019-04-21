package com.example.admin.frameworkdemo.StrategyModel;

import android.util.Log;

public class NewCustomer implements IGetPrice{
    private final static String TAG = "StrategyModel";
    @Override
    public int getDiscountPrice(int originalPrice) {
        Log.d(TAG, "新客户没有打折");
        return originalPrice;
    }
}
