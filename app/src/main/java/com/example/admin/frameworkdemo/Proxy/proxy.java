package com.example.admin.frameworkdemo.Proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxy {
    private static final String TAG = "porxy";
    public proxy() {
    }

    public void test(){
        //staticProxyTest();
        dynamicProxyTest();
    }

    /************************staticProxyTest***********************/
    public void staticProxyTest(){
        Student student = new Student();
        ProxyTest proxyTest = new ProxyTest(student);
        proxyTest.sayHello("jack", 19);
        Log.d(TAG,"**********************");
        proxyTest.sayGoodBye(true, 1000);
    }
    public class Student implements Person{
        @Override
        public void sayHello(String content, int age) {
            Log.d(TAG, "student say hello " + "content=" + content + "age="+age);
        }

        @Override
        public void sayGoodBye(boolean seeAgin, double time) {
            Log.d(TAG, "student say goodbye " + "seeAgin=" + seeAgin + "time="+time);
        }
    }

    public class ProxyTest implements Person{
        Student stu;
        public ProxyTest(Student student){
            stu = student;
        }

        @Override
        public void sayHello(String content, int age) {
            Log.d(TAG, "I am sayHello proxy start");
            stu.sayHello(content, age);
            Log.d(TAG, "I am sayHello proxy end");
        }

        @Override
        public void sayGoodBye(boolean seeAgin, double time) {
            Log.d(TAG, "I am sayGoodBye proxy start");
            stu.sayGoodBye(seeAgin, time);
            Log.d(TAG, "I am sayGoodBye proxy end");
        }
    }

    /************************staticProxyTest***********************/


    /************************DynamicProxyTest**********************/

    /************************DynamicProxyTest**********************/

    public void dynamicProxyTest(){
        Student student = new Student();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(student);
        Person person = (Person) Proxy.newProxyInstance(student.getClass().getClassLoader(), student.getClass().getInterfaces(),myInvocationHandler);
        person.sayHello("Durant", 15);
        person.sayGoodBye(true, 1000);
    }

    public class MyInvocationHandler implements InvocationHandler{
        private Object object;
        public MyInvocationHandler(Object o){
            object = o;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Log.d(TAG, "MyInvocation trans begin");
            Log.d(TAG, "proxy:" + proxy.getClass().getName());
            Log.d(TAG, "method:" + method.getName());
           /* for(Object o : args){
                System.out.println("arg: "+ o);
            }*/
            method.invoke(object, args);
            Log.d(TAG, "MyInvocation trans end");
            return null;
        }
    }
}
