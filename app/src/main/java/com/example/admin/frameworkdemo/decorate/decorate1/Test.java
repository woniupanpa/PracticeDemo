package com.example.admin.frameworkdemo.decorate.decorate1;

/**
 * @author yanjim
 * @Date 2021/9/16 08:16
 */
public class Test {

    public static void main(String[] args) {
        Animal pig = new Pig();
        pig = new Run(pig);
        pig = new Fly(pig);
        pig.action();
    }
}
