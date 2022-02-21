package com.example.admin.frameworkdemo.interfaceandabstract;

/**
 * @author yanjim
 * @Date 2021/9/16 16:13
 */
public class Swallow implements Animal, AnimalFly{

    @Override
    public void eat() {
        System.out.println("Swallow eat");
    }

    @Override
    public void fly() {
        System.out.println("Swallow fly");
    }
}
