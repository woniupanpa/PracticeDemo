package com.example.admin.frameworkdemo.classLoader;

import com.example.admin.frameworkdemo.MainActivity;

/**
 * @author yanjim
 * @Date 2021/5/10 17:04
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = MainActivity.class.getClassLoader();
        while(classLoader != null){
            System.out.println("classLoader: " + classLoader);
            classLoader = classLoader.getParent();
        }
    }
}
