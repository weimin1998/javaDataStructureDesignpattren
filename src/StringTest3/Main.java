package StringTest3;

/**
 * @Author weimin
 * @Date 2020/10/7 0007 10:25
 */
public class Main {
    public static void main(String[] args) {
        String s = "   qwer   ";
        System.out.println(s.trim().length());

        System.out.println(trim(s));
        System.out.println(trim(s).length());

        String str = "weimin";
        System.out.println(reserve(str));

        //System.out.println(partReserve(str, "cde"));

        String s1 = "absdabsdddabjwabhahaabbab";
        String s2 = "ab";
        int count = count(s1,s2);
        System.out.println(count);
    }

    private static int count(String s1, String s2) {
        int result = 0;
        if(!s1.contains(s2)){
            return result;
        }
        while (s1.contains(s2)){
            result ++;
            s1 = s1.substring(s1.indexOf(s2)+s2.length());
        }
        return result;
    }

    public static String trim(String s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                start = i;
                break;
            }
        }

        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) != ' ') {
                end = i + 1;
                break;
            }
        }
        return s.substring(start, end);
    }

    public static String reserve(String s) {
        char[] chars = s.toCharArray();
        char[] chars1 = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            chars1[i] = chars[chars.length - 1 - i];
        }

        return new String(chars1);

    }

    public static String partReserve(String s, String s1) {
        int i = s.indexOf(s1);
        int i1 = i + s1.length();
        String reserve = reserve(s1);
        String substring1 = s.substring(0, i);
        String substring2 = s.substring(i1);

        return substring1 + reserve + substring2;
    }

    /**
     * 最大相同字串
     * abcdehellofgf
     * asdqwhellooo
     */
    public static String maxCommon(String s1,String s2){
        if(s1.contains(s2)){
            return s2;
        }
        return null;
    }
}
