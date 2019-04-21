package com.example.admin.frameworkdemo.StrategyModel;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

public class StrategyMainActivity extends Activity {
    private final static String TAG = "StrategyModel";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IGetPrice oldCustomer = new OldCustomer();
        GetPriceContext context = new GetPriceContext(oldCustomer);
        int price = context.getRealPrice(100);
        Log.d(TAG, "折扣后的价格为"+price);
    }
}
