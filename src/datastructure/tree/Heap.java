package datastructure.tree;

import java.util.Arrays;

/**
 * @Author weimin
 * @Date 2020/10/19 0019 14:42
 * 堆排序
 */
public class Heap {
    public static void main(String[] args) {
        // int[] array = {9, 3, 4, 1, 7, 6, 8, 5, 2};
        int[] array = {4, 7, 5, 8, 6, 9, 3};
        heapsort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void adjust(int[] array, int i, int length) {
        int value = array[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            if (array[k] > value) {
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
        }

        array[i] = value;
    }

    public static void heapsort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjust(array, i, array.length);
        }

        for (int j = array.length - 1; j > 0; j--) {
            //
            int temp = array[0];
            array[0] = array[j];
            array[j] = temp;
            adjust(array, 0, j);
        }

    }
}
