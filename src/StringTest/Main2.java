package StringTest;

/**
 * @Author weimin
 * @Date 2020/10/6 0006 20:55
 */
public class Main2 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";

        String s3 = "helloworld";
        String s4 = "hello" + "world";
        String s5 = s1 + "world";
        String s6 = "hello" + s2;
        String s7 = s1 + s2;


        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);

        String s8 = s5.intern();
        System.out.println(s3 == s8);

    }
}
