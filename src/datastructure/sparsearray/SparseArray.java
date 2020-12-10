package datastructure.sparsearray;

import java.util.Arrays;

/**
 * @Author weimin
 * @Date 2020/10/8 0008 19:40
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] array = new int[11][11];
        array[2][3] = 1;
        array[5][8] = 2;
        array[9][1] = 1;


        int count = 0;
        System.out.println("原数组：");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
                if(array[i][j]!=0){
                    count++;
                }
                if(j==10){
                    System.out.println();
                }
            }
        }

        System.out.println("有效值的个数："+count);

        // 稀疏数组
        int[][] sparse = new int[count+1][3];
        sparse[0][0] = array.length;
        sparse[0][1] = array.length;
        sparse[0][2] = count;

        int num = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j]!=0){
                    sparse[num][0] = i;
                    sparse[num][1] = j;
                    sparse[num][2] = array[i][j];
                    num++;
                }
            }
        }

        System.out.println("稀疏数组：");
        for (int i = 0; i < sparse.length; i++) {
            for (int j = 0; j < sparse[i].length; j++) {
                System.out.print(sparse[i][j]+" ");
                if(j==2){
                    System.out.println();
                }
            }
        }

        // 转回去

        int[][] init = new int[sparse[0][0]][sparse[0][1]];
        for (int i = 1; i < sparse.length; i++) {
            init[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }

        System.out.println("转回原来的：");
        for (int i = 0; i < init.length; i++) {
            for (int j = 0; j < init[i].length; j++) {
                System.out.print(init[i][j]+" ");
                if(j==10){
                    System.out.println();
                }
            }
        }

    }
}
