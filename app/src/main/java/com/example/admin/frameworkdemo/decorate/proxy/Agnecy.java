package com.example.admin.frameworkdemo.decorate.proxy;

/**
 * @author yanjim
 * @Date 2021/9/16 08:55
 */
public class Agnecy implements Consumer{

    private Consumer consumer;

    public Agnecy() {
        this.consumer = new Jack();
    }

    @Override
    public void buyHouse() {
        System.out.println("do many task....");
        consumer.buyHouse();
        System.out.println("do many task again....");
    }
}
