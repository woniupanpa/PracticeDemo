package com.example.admin.frameworkdemo.abstarct;

/**
 * @author yanjim
 * @Date 2021/9/16 16:22
 */
public class Swallow extends Animal implements AnimalFlyIinterface{

    @Override
    public void eat() {
        System.out.println("Swallo eat");
    }

    @Override
    public void fly() {
        System.out.println("Swallo fly");
    }
}
