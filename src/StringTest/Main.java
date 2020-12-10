package StringTest;

/**
 * @Author weimin
 * @Date 2020/10/6 0006 16:36
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";

        //new 的方式：
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s4 == s3);


        String a = "nanchang".toUpperCase();
        System.out.println(a);
    }
}
