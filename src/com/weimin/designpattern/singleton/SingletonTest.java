package com.weimin.designpattern.singleton;

/**
 * @Author weimin
 * @Date 2020/10/4 0004 22:56
 * 单例模式
 */
public class SingletonTest {

    public static void main(String[] args) {

        Singleton_6 instance2 = Singleton_6.getInstance();
        Singleton_6 instance = Singleton_6.getInstance();
        System.out.println(instance == instance2);

        Singleton_8 instance1 = Singleton_8.INSTANCE;
        Singleton_8 instance3 = Singleton_8.INSTANCE;
        System.out.println(instance1 == instance3);

    }
}

/**
 * 饿汉式 静态常量
 */
class Singleton_1 {
    // 私有化构造器
    private Singleton_1() {
    }

    // 在类加载的时候就完成了实例化，避免线程同步问题
    // 如果没有用到这个实例，就会浪费内存
    private static Singleton_1 instance = new Singleton_1();

    public static Singleton_1 getInstance() {
        return instance;
    }
}


/**
 * 饿汉式 静态代码块
 */
class Singleton_2 {
    // 私有化构造器
    private Singleton_2() {
    }

    // 在类加载的时候就完成了实例化，避免线程同步问题
    // 如果没有用到这个实例，就会浪费内存
    private static Singleton_2 instance;

    static {
        instance = new Singleton_2();
    }

    public static Singleton_2 getInstance() {
        return instance;
    }
}

/**
 * 懒汉式 线程不安全
 */
class Singleton_3 {
    private Singleton_3() {
    }

    private static Singleton_3 instance;

    public static Singleton_3 getInstance() {
        if (instance == null) {
            instance = new Singleton_3();
        }
        return instance;
    }
}

/**
 * 懒汉式 同步方法 线程安全
 */
class Singleton_4 {
    private Singleton_4() {
    }

    private static Singleton_4 instance;

    public static synchronized Singleton_4 getInstance() {
        if (instance == null) {
            instance = new Singleton_4();
        }
        return instance;
    }
}

/**
 * 懒汉式 同步代码 更不靠谱了
 */
class Singleton_5 {
    private Singleton_5() {
    }

    private static Singleton_5 instance;

    public static Singleton_5 getInstance() {
        if (instance == null) {
            synchronized (Singleton_5.class) {
                instance = new Singleton_5();
            }

        }
        return instance;
    }
}

/**
 * 双重检查
 */
class Singleton_6 {
    private Singleton_6() {
    }

    private static volatile Singleton_6 instance;

    public static Singleton_6 getInstance() {
        if (instance == null) {
            synchronized (Singleton_6.class) {
                if (instance == null) {
                    instance = new Singleton_6();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态内部类
 */
class Singleton_7{

    private Singleton_7(){}

    // 外部类加载的时候，静态内部类不会加载，在调用的时候会加载，加载只有一次，是线程安全的，并且是懒加载
    private static class Single{
        private static Single single = new Single();
    }

    public static Single getSingle(){
        return Single.single;
    }
}

/**
 * 枚举 避免多线程的问题，还可以防止反序列化
 */
enum Singleton_8{
    INSTANCE;
}