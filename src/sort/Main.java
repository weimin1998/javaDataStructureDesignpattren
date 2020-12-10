package sort;

import java.util.Arrays;

/**
 * @Author weimin
 * @Date 2020/10/8 0008 17:14
 */
public class Main {
    public static void main(String[] args) {
        int[] ints = new int[]{8, 6, 9, 0, 3, 7, 1, 2};
        maopao(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void maopao(int[] array) {

        boolean isChange = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    isChange = true;
                    array[j] = array[j] + array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
            }
            if(isChange){
                isChange = false;
            }else {
                break;
            }
        }
    }
}
