package com.example.admin.frameworkdemo.factory;

/**
 * @author yanjim
 * @Date 2021/5/24 10:14
 */
//https://www.cnblogs.com/my-king/p/5338603.html
public class FactoryTest {
    public static void main(String[] args) {
        //创建小米工厂
        ProductFactory xiaoMiProductFactory = new XiaoMiProductFactory();

        //用小米工厂生产小米手机和杯子
        PhoneProduct phone = xiaoMiProductFactory.phone();
        phone.call();

        CupProduct cup = xiaoMiProductFactory.cup();
        cup.drink();

        //假如这时候我们要换成华为的手机和杯子，只需要增加一个HuaweiFactory就可以了，
        //降低耦合；
        //抽象工厂模式，就是工厂也可以抽象成接口；
    }

    //小米工厂实现类
    public static class XiaoMiProductFactory implements ProductFactory {
        @Override
        public PhoneProduct phone() {
            return new XiaoMiPhone();
        }

        @Override
        public CupProduct cup() {
            return new XiaoMiCup();
        }
    }

    //小米手机实现类
    public static class XiaoMiPhone implements PhoneProduct {
        @Override
        public void call() {
            System.out.println("用小米手机打电话");
        }
    }

    //小米杯子实现类
    public static class XiaoMiCup implements CupProduct {
        @Override
        public void drink() {
            System.out.println("用小米杯子喝水");
        }
    }

    //产品接口：杯子
    public interface CupProduct {
        void drink();
    }

    //产品接口：手机
    public interface PhoneProduct {
        void call();
    }

    //抽象工厂
    public interface ProductFactory {
        CupProduct cup();

        PhoneProduct phone();
    }
}
