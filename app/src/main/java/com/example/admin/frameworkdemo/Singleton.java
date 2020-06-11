package com.example.admin.frameworkdemo;

public class Singleton {
    //饿汉模式
   /*private static Singleton singleton = new Singleton();
   public Singleton(){

   }
   public static Singleton getInstance(){
       return singleton;
   }*/

   //懒汉模式(比安全)
    /*private static Singleton singleton;
    public Singleton(){

    }
    public static Singleton getInstance(){
        if(singleton == null){
            return  new Singleton();
        }
        return singleton;
    }*/

    //懒汉模式：优化1
    /*private static Singleton singleton;
    public Singleton(){
    }
    public static synchronized Singleton getSingleton(){
        if(singleton == null){
            return new Singleton();
        }
        return singleton;
    }*/

    //懒汉模式2：缩小枷锁范围
   /* private static Singleton singleton;
    public Singleton(){
    }
    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (Singleton.class){
                return new Singleton();
            }
        }
        return singleton;
    }*/

    //双重枷锁
   /* private static Singleton singleton;
    public Singleton(){
    }
    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    return new Singleton();
                }
            }
        }
        return singleton;
    }*/

   //考虑原子性
  /* private static volatile Singleton singleton;
    public Singleton(){
    }
    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    return new Singleton();
                }
            }
        }
        return singleton;
    }*/


      /*private static volatile Singleton singleton;
      public Singleton(){

      }
      public static Singleton getInstance(){
          if(singleton == null){
              synchronized (Singleton.class){
                  if(singleton == null){
                      return new Singleton();
                  }
              }
          }
          return singleton;
      }*/

      //静态内部类
   private Singleton(){

   }

   public Singleton getInstance(){
       return SingleHolder.singleton;
   }

   private static class SingleHolder{
       private static final Singleton singleton = new Singleton();
    }

}
