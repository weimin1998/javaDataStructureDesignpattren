package StringBuffer;

/**
 * @Author weimin
 * @Date 2020/10/7 0007 14:19
 */
public class Test {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("abc");
        stringBuffer.setCharAt(1,'s');
        System.out.println(stringBuffer);
        stringBuffer.append("aa");

        char a = 'a';
        System.out.println(a << 2);
        test();
    }

    public static void test(){
        String string = "";
        StringBuffer stringBuffer = new StringBuffer(16);
        StringBuilder stringBuilder = new StringBuilder(16);

        long start;
        long end;
        start = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            string = string + "a";
        }
        end = System.currentTimeMillis();

        System.out.println("String："+(end-start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            stringBuffer = stringBuffer.append("a");
        }
        end = System.currentTimeMillis();

        System.out.println("StringBuffer："+(end-start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            stringBuilder = stringBuilder.append("a");
        }
        end = System.currentTimeMillis();

        System.out.println("StringBuilder："+(end-start));

    }
}
