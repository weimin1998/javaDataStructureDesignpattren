package data;

/**
 * @Author weimin
 * @Date 2020/10/9 0009 15:18
 */
public class Main2 {
    public static void main(String[] args) {
        String hexString = Integer.toHexString(16);
        System.out.println(hexString);
        String s = Integer.toBinaryString(16);
        System.out.println(s);
        String octalString = Integer.toOctalString(16);
        System.out.println(octalString);
    }
}
