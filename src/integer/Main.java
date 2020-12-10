package integer;

/**
 * @Author weimin
 * @Date 2020/10/9 0009 10:11
 */
public class Main {
    public static void main(String[] args) {
        Integer i = 127;
        Integer i1 = 127;

        System.out.println(i == i1);

        Integer i2 = 128;
        Integer i3 = 128;
        System.out.println(i2 == i3);

        Integer i4 = -128;
        Integer i5 = -128;
        System.out.println(i4 == i5);

        Integer i6 = -129;
        Integer i7 = -129;
        System.out.println(i6 == i7);
    }
}
