package StringTest;

/**
 * @Author weimin
 * @Date 2020/10/7 0007 10:11
 */
public class Main5 {
    public static void main(String[] args) {
        String s1 = "helloworld";
        String s2 = "hello";
        String s3 = s2 + "world";

        System.out.println(s1 == s3);  //false

        final String s4 = "hello";
        String s5 = s4 + "world";
        System.out.println(s1 == s5);  // true 因为s4是常量
    }
}
