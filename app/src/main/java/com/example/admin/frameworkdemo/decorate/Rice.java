package com.example.admin.frameworkdemo.decorate;

/**
 * @author yanjim
 * @Date 2021/9/15 08:34
 */
public class Rice implements Food{

    @Override
    public void printIngredients() {
        System.out.println("Rice");
    }
}
