package compare;

import java.util.*;

/**
 * @Author weimin
 * @Date 2020/10/7 0007 20:36
 */
public class Lion implements Comparable{

    private String name;
    private Integer age;

    public Lion(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Lion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Lion lion = (Lion) o;
        if(this.age>lion.age){
            return 1;
        }else if(this.age.equals(lion.age)){
            return 0;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Lion lion1 = new Lion("辛巴",5);
        Lion lion2 = new Lion("木法沙",8);
        Lion lion3 = new Lion("娜拉",4);

        Lion[] lions = {lion1, lion2, lion3};
        Arrays.sort(lions);

        System.out.println(Arrays.toString(lions));

        Arrays.sort(lions, (o1, o2) -> o2.age - o1.age);

        System.out.println(Arrays.toString(lions));



        List<Lion> list = new ArrayList<>();
        list.add(lion1);
        list.add(lion2);
        list.add(lion3);
        Collections.sort(list);
        System.out.println(list);
    }
}