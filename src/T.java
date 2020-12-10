import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class T {
    public static void main(String[] args) {
        System.out.println((int) '1');

        System.out.println((char)(97));

        Map<String, Integer> map = new HashMap<>();
        Set<String> keySet = map.keySet();

        map.put("1",1);
        map.put("2",2);
        map.put("4",4);
        map.put("3",3);

        System.out.println(keySet);

        Integer a = 256;
        System.out.println(Integer.toBinaryString(a));


        System.out.println((byte)Integer.parseInt("10101000", 2));
        System.out.println(Integer.parseInt("10101000", 2));

    }
}
