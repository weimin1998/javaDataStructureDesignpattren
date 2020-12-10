package datastructure.recursion;

/**
 * @Author weimin
 * @Date 2020/10/14 0014 14:34
 */
public class Jiecheng {

    public static int test(int i){
        if(i==1||i==0){
            return 1;
        }else {
            return test(i-1)*i;
        }
    }

    public static void main(String[] args) {
        System.out.println(test(4));
    }
}
