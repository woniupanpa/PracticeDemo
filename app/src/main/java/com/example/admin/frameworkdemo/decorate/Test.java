package com.example.admin.frameworkdemo.decorate;

/**
 * @author yanjim
 * @Date 2021/9/15 08:37
 */
public class Test {

    public static void main(String[] args) {
        Food rice = new Rice();
        rice = new RiceFriedWithEgg(rice);
        rice.printIngredients();
    }
}
