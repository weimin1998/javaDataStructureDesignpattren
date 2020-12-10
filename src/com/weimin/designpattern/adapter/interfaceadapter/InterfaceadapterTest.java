package com.weimin.designpattern.adapter.interfaceadapter;

/**
 * @Author weimin
 * @Date 2020/10/6 0006 13:24
 */
public class InterfaceadapterTest {
    public static void main(String[] args) {

    }
}

interface source{
    void method1();
    void method2();
    void method3();
    void method4();
}

abstract class Abs implements source{
    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void method3() {

    }

    @Override
    public void method4() {

    }
}

class target extends Abs{
    // 选择性的实现想要的方法
    @Override
    public void method1() {
        super.method1();
    }
}