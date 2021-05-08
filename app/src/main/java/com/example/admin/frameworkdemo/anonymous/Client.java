package com.example.admin.frameworkdemo.anonymous;

/**
 * @author yanjim
 * @Date 2021/4/25 15:11
 */
public class Client {

    private static final String TAG = Client.class.getSimpleName();

    public void run() {
        OutClass.InnerClass innerClass = new OutClass().new InnerClass() {
            @Override
            public void test() {
                System.out.println(TAG + "---> test");
            }
        };
        innerClass.test();
    }
}
