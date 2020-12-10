package com.weimin.designpattern.builder;

/**
 * @Author weimin
 * @Date 2020/10/5 0005 19:13
 */
public class BuilderTest {
    public static void main(String[] args) {
        Commander commander = new Commander(new CommonHouseBuilder());
        House house = commander.construct();
        System.out.println(house);

        commander.setHouseBuilder(new HighHouseBuilder());
        House house1 = commander.construct();
        System.out.println(house1);
    }
}

/**
 * 房子
 */
class House{
    private String base;
    private String wall;
    private String head;

    public void setBase(String base) {
        this.base = base;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "House{" +
                "base='" + base + '\'' +
                ", wall='" + wall + '\'' +
                ", head='" + head + '\'' +
                '}';
    }
}

/**
 * 造房子的创建者，组合一个房子
 */
abstract class HouseBuilder{
     public House house = new House();

    /**
     * 打地基
     */
    abstract void doBase();

    /**
     * 砌墙
     */
     abstract void doWall();

    /**
     * 封顶
     */
    abstract void doHead();

    public House build(){
        return house;
    }
}

/**
 * 普通房子建造者
 */
class CommonHouseBuilder extends HouseBuilder{

    @Override
    void doBase() {
        house.setBase("普通房子的地基");
    }

    @Override
    void doWall() {
        house.setWall("普通房子的墙");
    }

    @Override
    void doHead() {
        house.setHead("普通房子封顶");
    }

}

/**
 * 高楼大厦创建者
 */
class HighHouseBuilder extends HouseBuilder{

    @Override
    void doBase() {
        house.setBase("高楼大厦的地基");
    }

    @Override
    void doWall() {
        house.setWall("高楼大厦的墙");
    }

    @Override
    void doHead() {
        house.setHead("高楼大厦的顶");
    }
}

/**
 * 指挥者，指挥具体的流程（决定方法执行的顺序），聚合一个房子创建者
 */
class Commander{
    HouseBuilder houseBuilder;

    public Commander(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House construct(){
        houseBuilder.doBase();
        houseBuilder.doWall();
        houseBuilder.doHead();
        return houseBuilder.build();
    }
}