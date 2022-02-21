package com.example.admin.frameworkdemo.decorate;

/**
 * @author yanjim
 * @Date 2021/9/15 08:36
 */
public class RiceFriedWithEgg implements Food{

    private Food food;

    public RiceFriedWithEgg(Food food) {
        this.food = food;
    }

    @Override
    public void printIngredients() {
        System.out.println("Egg");
        food.printIngredients();
    }
}
