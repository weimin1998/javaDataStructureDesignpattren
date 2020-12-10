package datastructure.kmp;

import java.util.Arrays;

/**
 * @Author weimin
 * @Date 2020/10/23 0023 16:21
 * kmp算法
 */
public class KMP {
    public static void main(String[] args) {

        String s1 = "BBC ABCDABC ABABABCDABDASFA";
        String s2 = "ABCDABD";
        /*int[] ints = kmpPartPatternTable(s2);
        System.out.println(Arrays.toString(ints));*/
        System.out.println(kmp(s1, s2));
    }

    // 部分匹配表
    public static int[] kmpPartPatternTable(String s){
        int[] ints = new int[s.length()];
        ints[0] = 0;

        for (int i = 1,j=0; i <s.length() ; i++) {
            while (j>0&&s.charAt(i)!=s.charAt(j)){
                j = ints[j-1];
            }

            if(s.charAt(i)==s.charAt(j)){
                j++;
            }
            ints[i] = j;
        }
        return ints;
    }

    // kmp搜索算法
    public static int kmp(String s1,String s2){
        int[] ints = kmpPartPatternTable(s2);

        for (int i = 0 ,j = 0; i < s1.length(); i++) {

            while (j>0&&s1.charAt(i)!=s2.charAt(j)){
                j = ints[j-1];
            }
            if(s1.charAt(i)==s2.charAt(j)){
                j++;
            }

            if(j==s2.length()){
                return i-j+1;
            }
        }

        return -1;
    }
}
