package com.example.admin.frameworkdemo.duotai;

/**
 * @author yanjim
 * @Date 2021/5/24 16:54
 */
public class Duotai {

    public static void main(String[] args) {
        Animal dog = new Dog();
        eat(dog);
        run(dog);

        Animal cat = new Cat();
        eat(cat);
        run(cat);
    }

    private static void eat(Animal animal) {
        animal.eat();
    }

    private static void run(Animal animal) {
        animal.run();
    }

    public static interface Animal {
        public void eat();

        public void run();
    }

    public static class Dog implements Animal {
        @Override
        public void eat() {
            System.out.println("dog eat");
        }

        @Override
        public void run() {
            System.out.println("dog run");
        }
    }


    public static class Cat implements Animal {
        @Override
        public void eat() {
            System.out.println("cat eat");
        }

        @Override
        public void run() {
            System.out.println("cat eat");
        }
    }
}
