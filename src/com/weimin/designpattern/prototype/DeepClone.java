package com.weimin.designpattern.prototype;

/**
 * @Author weimin
 * @Date 2020/10/5 0005 18:38
 */
public class DeepClone {
    public static void main(String[] args) {
        Lion lion = new Lion("辛巴", new Tiger("拉贾"));

        Lion clone = (Lion) lion.clone();

        System.out.println(lion);
        System.out.println(clone);

        System.out.println(lion.getFriend().hashCode());
        System.out.println(clone.getFriend().hashCode());

        System.out.println(lion.getFriend() == clone.getFriend());

    }
}

class Lion implements Cloneable{
    private String name;
    private Tiger friend;

    public Lion(String name, Tiger friend) {
        this.name = name;
        this.friend = friend;
    }

    public Tiger getFriend() {
        return friend;
    }

    @Override
    protected Object clone() {
        Lion lion = null;
        try {
            lion = (Lion) super.clone();
            friend = (Tiger) friend.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return lion;
    }

    @Override
    public String toString() {
        return "Lion{" +
                "name='" + name + '\'' +
                ", friend=" + friend +
                '}';
    }
}

class Tiger implements Cloneable{
    private String name;

    public Tiger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}