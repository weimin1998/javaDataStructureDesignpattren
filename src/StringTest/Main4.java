package StringTest;

/**
 * @Author weimin
 * @Date 2020/10/6 0006 22:10
 */
public class Main4 {
    public static void main(String[] args) {
        int a = 1;
        test(a);
        System.out.println(a);

        String s = "hehe";
        test2(s);
        System.out.println(s);

        Object o = new Object();
        System.out.println(o);
        test3(o);
        System.out.println(o);

        Lion lion = new Lion();
        lion.setName("辛巴");
        test4(lion);
        System.out.println(lion.getName());

    }
    public static void test(int a){
        a = 2;
    }

    public static void test2(String s){
        s = "haha";
    }
    public static void test3(Object o){
        o = new Object();
    }
    public static void test4(Lion lion){
        lion.setName("木法沙");
    }
}

class Lion{
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
