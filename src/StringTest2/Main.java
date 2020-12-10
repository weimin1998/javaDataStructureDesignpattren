package StringTest2;

import java.util.Arrays;

/**
 * @Author weimin
 * @Date 2020/10/6 0006 22:31
 */
public class Main {
    public static void main(String[] args) {
        String s = "weimin";

        System.out.println(s.isEmpty()); // 根据字符串的长度判断
        System.out.println(s.length());

        String s1 = s.toUpperCase();
        System.out.println(s1);
        System.out.println(s);

        System.out.println(s.compareTo("abc"));

        char[] chars = s.toCharArray();
        System.out.println(chars);
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));
    }
}
