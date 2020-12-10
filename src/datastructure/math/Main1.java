package datastructure.math;

/**
 * @Author weimin
 * @Date 2020/10/14 0014 17:11
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println(test1(999, 66));
        System.out.println(test11(150, 550));
        //test2(9999,6666);

        //System.out.println(isZhiShu(39));

        //test3(1000);

        //System.out.println(test4(150, 410));

    }

    // 最大公约数
    public static int test1(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        if (max % min == 0) {
            return min;
        }
        for (int i = min / 2 + 1; i >= 1; i--) {
            if (min % i == 0 && max % i == 0) {
                return i;
            }
        }

        return 0;

    }

    public static int test11(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        while (max % min != 0) {
            int c = max % min;
            max = min;
            min = c;
        }
        return min;
    }

    // 所有的约束
    public static void test2(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        if (max % min == 0) {
            System.out.println(min);
        }
        for (int i = min / 2 + 1; i >= 1; i--) {
            if (min % i == 0 && max % i == 0) {
                System.out.println(i);
            }
        }


    }

    // 多少以内的质数
    public static void test3(int data) {
        for (int i = data; i > 0; i--) {
            if (isZhiShu(i)) {
                System.out.println(i);
            }
        }
    }

    // 判断是否是个质数
    public static boolean isZhiShu(int n) {
        int count = 0;
        for (int i = n / 2; i > 0; i--) {
            if (n % i == 0) {
                //System.out.println(i);
                count++;
            }
        }
        //System.out.println(count);
        return count == 1;
    }

    // 最小公倍数
    public static int test4(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (max % min == 0) {
            return max;
        } else {
            int i = test1(max, min);
            return max * min / i;
        }

    }

}
