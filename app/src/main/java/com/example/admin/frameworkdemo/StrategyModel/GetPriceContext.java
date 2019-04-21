package com.example.admin.frameworkdemo.StrategyModel;

public class GetPriceContext {
    private IGetPrice getPrice;//持有一个具体的报价策略；
    //注入具体报价
    public GetPriceContext(IGetPrice getPrice) {
        this.getPrice = getPrice;
    }

    public int getRealPrice(int price){
        return getPrice.getDiscountPrice(price);
    }
}
