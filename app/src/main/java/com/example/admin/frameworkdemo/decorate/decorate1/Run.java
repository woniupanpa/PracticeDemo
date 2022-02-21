package com.example.admin.frameworkdemo.decorate.decorate1;

/**
 * @author yanjim
 * @Date 2021/9/16 08:27
 */
public class Run implements Animal{
    Animal animal = null;

    public Run(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void action() {
        animal.action();
        System.out.println("run");
    }
}
