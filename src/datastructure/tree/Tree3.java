package datastructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author weimin
 * @Date 2020/10/19 0019 16:41
 * 哈夫曼树
 */
public class Tree3 {

    public static void main(String[] args) {
        //
        int[] array = {4, 7, 5, 8, 6, 9, 3};

        Node hafuman = toHuffman(array);

        pre(hafuman);
    }

    public static void pre(Node node){
        System.out.println(node.data);
        if(node.left!=null){
            pre(node.left);
        }
        if(node.right!=null){
            pre(node.right);
        }
    }

    public static Node toHuffman(int[] array) {
        List<Node> list = new ArrayList<>();
        for (int i:array){
            list.add(new Node(i));
        }


        while (list.size()>1){
            Collections.sort(list);

            Node leftNode = list.get(0);
            Node rightNode = list.get(1);

            Node parent = new Node(leftNode.data + rightNode.data);
            parent.left = leftNode;
            parent.right = rightNode;

            list.remove(leftNode);
            list.remove(rightNode);

            list.add(parent);
        }

        return list.get(0);

    }


    static class Node implements Comparable<Node>{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.data-o.data;
        }
    }
}
