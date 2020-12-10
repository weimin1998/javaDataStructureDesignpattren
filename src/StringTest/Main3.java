package StringTest;

/**
 * @Author weimin
 * @Date 2020/10/6 0006 21:39
 */
public class Main3 {
    String string = new String("good");
    char[] chars = {'t','e','s','t'};

    public void change(String str,char[] chars){
        str = "haha";
        chars[0] = 'b';
    }
    public static void main(String[] args) {
        Main3 main3 = new Main3();
        main3.change(main3.string,main3.chars);
        System.out.println(main3.string); // good
        System.out.println(main3.chars); // best
    }
}
