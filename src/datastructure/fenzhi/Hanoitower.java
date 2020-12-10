package datastructure.fenzhi;

/**
 * @Author weimin
 * @Date 2020/10/22 0022 17:46
 */
public class Hanoitower {
    public static void main(String[] args) {
        hannuotower(64,'a','b','c');
    }

    public static void hannuotower(int num,char a,char b,char c){
        if(num==1){
            System.out.println("第1个盘从"+a+"到"+c);
        }else {
            hannuotower(num-1,a,c,b);
            System.out.println("第"+num+"个盘从"+a+"到"+c);
            hannuotower(num-1,b,a,c);
        }
    }
}
