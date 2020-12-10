package com.weimin.designpattern.factory;

import java.util.Calendar;

/**
 * @Author weimin
 * @Date 2020/10/5 0005 14:29
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        Fruit apple = FruitFactory.product("apple");
        System.out.println(apple);
        Fruit haha = FruitFactory.product("haha");
        System.out.println(haha);

    }
}

class FruitFactory{
    //
    public static Fruit product(String name){
        switch (name){
            case "apple":
                return new Apple();
            case "banana":
                return new Banana();
            case "pear":
                return new Pear();
            case "orange":
                return new Orange();
            default:
                return null;
        }
    }
}
// 水果
interface Fruit{}

class Apple implements Fruit{}
class Banana implements Fruit{}
class Pear implements Fruit{}
class Orange implements Fruit{}
