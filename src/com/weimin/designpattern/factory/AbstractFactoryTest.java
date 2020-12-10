package com.weimin.designpattern.factory;

/**
 * @Author weimin
 * @Date 2020/10/5 0005 15:18
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        MeatFactory pigMeatFactory = new PigMeatFactory();
        MeatFactory chickenFactory = new ChickenFactory();

        Meat pigMeat = pigMeatFactory.product();
        System.out.println(pigMeat);

        Meat chicken = chickenFactory.product();
        System.out.println(chicken);
    }
}

interface MeatFactory{
    Meat product();
}
interface Meat{}

class PigMeatFactory implements MeatFactory{
    @Override
    public Meat product() {
        return new PigMeat();
    }
    class PigMeat implements Meat{}
}

class ChickenFactory implements MeatFactory{
    @Override
    public Meat product() {
        return new Chicken();
    }
    class Chicken implements Meat{}
}

