package com.example.admin.frameworkdemo.decorate.decorate1;

/**
 * @author yanjim
 * @Date 2021/9/16 08:29
 */
public class Fly implements Animal{

    Animal animal = null;

    public Fly(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void action() {
        animal.action();
        System.out.println("fly");
    }
}
