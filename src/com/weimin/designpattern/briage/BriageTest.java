package com.weimin.designpattern.briage;

/**
 * @Author weimin
 * @Date 2020/10/6 0006 15:12
 */
public class BriageTest {
    public static void main(String[] args) {
        new ZhediePhone(new Vivo()).open();

        new ZhediePhone(new XiaoMi()).open();

        new FanGaiPhone(new Vivo()).open();

        new FanGaiPhone(new Oppo()).open();
    }
}

abstract class Brand{
    abstract void open();
    abstract void shutdown();
}

class Vivo extends Brand{

    @Override
    void open() {
        System.out.println("vivo开机");
    }

    @Override
    void shutdown() {
        System.out.println("vivo关机");
    }
}

class XiaoMi extends Brand{
    @Override
    void open() {
        System.out.println("小米开机");
    }

    @Override
    void shutdown() {
        System.out.println("小米关机");
    }
}

class Oppo extends Brand{
    @Override
    void open() {
        System.out.println("oppo开机");
    }

    @Override
    void shutdown() {
        System.out.println("oppo关机");
    }
}

abstract class Phone{
    Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    public void open(){
        brand.open();
    }

    public void shutdown(){
        brand.shutdown();
    }

}

class ZhediePhone extends Phone{

    public ZhediePhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
        System.out.println("折叠式手机");
    }

    @Override
    public void shutdown() {
        super.shutdown();
        System.out.println("折叠式手机");
    }
}

class FanGaiPhone extends Phone{
    public FanGaiPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
        System.out.println("翻盖手机");
    }

    @Override
    public void shutdown() {
        super.shutdown();
        System.out.println("翻盖手机");
    }
}