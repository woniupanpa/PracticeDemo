package com.example.admin.frameworkdemo.StrategyModel;

//报价策略接口
public interface IGetPrice {
    //获取折价后的价格
    int getDiscountPrice(int originalPrice);
}
