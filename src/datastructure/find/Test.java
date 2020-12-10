package datastructure.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author weimin
 * @Date 2020/10/15 0015 15:06
 */
public class Test {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 7, 8, 9, 14, 22, 35};

        //System.out.println(find(array, 7, 0, array.length));
        //System.out.println(find2(array, 0, 0, array.length));

        /*int[] arr = new int[100];

        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }

        System.out.println(arr[3]);
        System.out.println(find3(arr, 33, 0, arr.length - 1));*/

        System.out.println(fibfind(array, 35));
    }

    // 二分查找（折半查找）  只存在一个结果
    public static int find(int[] array, int value, int left, int right) {
        if (left > right || value < array[0] || value > array[array.length - 1]) {
            return -1;
        }

        int mid = (left + right) / 2;
        int i = array[mid];

        if (value > i) {
            return find(array, value, mid + 1, right);
        } else if (value < i) {
            return find(array, value, left, mid - 1);
        } else {
            return mid;
        }

    }

    // 二分查找  多个结果
    public static List<Integer> find2(int[] array, int value, int left, int right) {
        if (left > right || value < array[0] || value > array[array.length - 1]) {
            return null;
        }

        int mid = (left + right) / 2;
        int i = array[mid];

        if (value > i) {
            return find2(array, value, mid + 1, right);
        } else if (value < i) {
            return find2(array, value, left, mid - 1);
        } else {

            List<Integer> list = new ArrayList<>();

            list.add(mid);

            for (int j = mid - 1; j > 0; j--) {
                if (array[mid] == array[j]) {
                    list.add(j);
                }
            }


            for (int j = mid + 1; j < array.length; j++) {
                if (array[mid] == array[j]) {
                    list.add(j);
                }
            }

            Collections.sort(list);
            return list;
        }

    }

    // 插值查找
    public static List<Integer> find3(int[] array, int value, int left, int right) {

        System.out.println("hello");
        if (left > right || value < array[0] || value > array[array.length - 1]) {
            return null;
        }

        int mid = left + (right - left) * (value - array[left]) / (array[right] - array[left]);
        int i = array[mid];

        if (value > i) {
            return find3(array, value, mid + 1, right);
        } else if (value < i) {
            return find3(array, value, left, mid - 1);
        } else {

            List<Integer> list = new ArrayList<>();

            list.add(mid);

            for (int j = mid - 1; j > 0; j--) {
                if (array[mid] == array[j]) {
                    list.add(j);
                }
            }


            for (int j = mid + 1; j < array.length; j++) {
                if (array[mid] == array[j]) {
                    list.add(j);
                }
            }

            Collections.sort(list);
            return list;
        }
    }

    public static int fibfind(int[] array,int value){
        int low = 0;
        int high = array.length-1;
        int k = 0;
        int mid = 0;

        int[] fib = fib(20);
        while (high>fib[k]-1){
            k++;
        }
        int[] temp = Arrays.copyOf(array, fib[k]);

        for(int i = array.length;i<temp.length;i++){
            temp[i] = array[high];
        }

        while (low<=high){
            mid = low + fib[k]-1;
            if(value<temp[mid]){
                high = mid -1;
                k--;
            }else if (value>temp[mid]){
                low = mid + 1;
                k -= 2;
            }else {
                if(mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;

    }

    public static int[] fib(int size){
        int[] array = new int[size];
        array[0] = 1;
        array[1] = 1;

        for (int i = 2; i <array.length ; i++) {
            array[i] = array[i-1]+array[i-2];
        }
        return array;
    }
}
