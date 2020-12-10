package datastructure.tree;

import java.util.Arrays;

/**
 * @Author weimin
 * @Date 2020/10/18 0018 14:05
 * 自己写的 。。。 不太行
 */
public class Deap {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        adjust(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    // 将数组调整为大顶堆的形式


    public static void adjust(int[] array, int length) {
        if (length == 1) {
            return;
        }
        // 第一个非叶子节点的索引
        int k = length / 2 - 1;
        // 对应的值
        int value = array[k];
        int left = array[k * 2 + 1];

        int right;
        if (k * 2 + 2 != length) {
            // 有右子节点
            right = array[k * 2 + 2];

            // 如果左子节点的值大于右子节点的值
            if (left > right) {
                if (left > value) {
                    // 交换
                    array[k] = left;
                    array[k * 2 + 1] = value;
                }
            } else {
                // 右子节点的值大于左子节点的值
                if (right > value) {
                    array[k] = right;
                    array[k * 2 + 2] = value;
                }
            }
        } else {
            // 没有右子节点，就只比较左子节点
            if (left > value) {
                // 交换
                array[k] = left;
                array[k * 2 + 1] = value;
            }
        }

        adjust(array, length-1);

        //
        /*if (k == 0) {
            if (!isBigTopDeap(array)) {
                adjust(array, array.length);
            }
            // 这时 满足大顶堆

        }*/

    }

    private static boolean isBigTopDeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(i*2+2<array.length){
                if(!(array[i]>array[i*2+1]&&array[i]>array[i*2+1])){
                    return false;
                }
            }

        }
        return true;
    }
}
