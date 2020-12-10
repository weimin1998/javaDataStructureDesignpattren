package com.weimin.designpattern.prototype;

/**
 * @Author weimin
 * @Date 2020/10/5 0005 16:59
 */
public class PrototypeTest {
    public static void main(String[] args) {
        Sheep sheep = new Sheep(2, "tom", "白色");

        Sheep clone1 = (Sheep) sheep.clone();
        System.out.println(sheep);
        System.out.println(clone1);

        System.out.println(sheep.getName() == clone1.getName());
        System.out.println(sheep.getName().equals(clone1.getName()));

    }
}
