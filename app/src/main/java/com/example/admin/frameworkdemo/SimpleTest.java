package com.example.admin.frameworkdemo;

import android.util.Log;

import java.util.Timer;

/**
 * @author yanjim
 * @Date 2021/4/9 10:08
 */
public class SimpleTest {
    public static void main(String[] args) {
        Test a = new Test(1, 2);
        Test b = a;
        System.out.println("aaaaaaaaaaaaa");
        b.setA(3);
        b.setB(4);
    }

    public static class Test {
        private int a;
        private int b;

        public Test(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
}
