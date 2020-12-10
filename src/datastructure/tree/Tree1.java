package datastructure.tree;

/**
 * @Author weimin
 * @Date 2020/10/16 0016 14:48
 * 顺序存储二叉树
 */
public class Tree1 {
    //
    private int[] array;

    public Tree1(int[] array) {
        this.array = array;
    }

    public void preArray(int index){
        System.out.println(array[index]);

        // 左递归
        if(index*2+1<array.length){
            preArray(index*2+1);
        }
        //右递归
        if(index*2+2<array.length){
            preArray(index*2+2);
        }
    }

    public void midArray(int index){
        if(index*2+1<array.length){
            midArray(index*2+1);
        }

        System.out.println(array[index]);

        if(index*2+2<array.length){
            midArray(index*2+2);
        }
    }

    public void behindArray(int index){
        if(index*2+1<array.length){
            behindArray(index*2+1);
        }

        if(index*2+2<array.length){
            behindArray(index*2+2);
        }
        System.out.println(array[index]);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};

        Tree1 tree1 = new Tree1(array);
        /*tree1.preArray(0);
        System.out.println("=============");*/
        //tree1.midArray(0);
        tree1.behindArray(0);
    }

}
