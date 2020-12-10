package datastructure.hash;

import java.util.Date;

/**
 * @Author weimin
 * @Date 2020/10/12 0012 15:06
 */
public class Hash {
    private Node[] table;
    private int size; // 数组的长度
    private int count; // 有效数据的个数

    public Hash(int size) {
        this.size = size;
        table = new Node[size];
    }

    public int count() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int index(Object o) {
        return o.hashCode() % size;
    }

    public void add(Object o) {
        int index = index(o);
        if (table[index] == null) {
            Node node = new Node(o);
            table[index] = node;
        } else {
            for (Node node = table[index]; node != null; node = node.next) {
                if (node.hash != o.hashCode() || !node.data.equals(o)) {
                    Node temp = table[index];
                    table[index] = new Node(o);
                    table[index].next = temp;
                }
            }
        }
        count++;
    }

    public void show() {
        for (int i = 0; i < table.length; i++) {
            for (Node node = table[i]; node != null; node = node.next) {
                System.out.println(node.data);
            }

        }
    }


    static class Node {
        private Node next;
        private Object data;
        private int hash;

        public Node(Object data) {
            this.data = data;
            this.next = null;
            this.hash = this.data.hashCode();
        }

    }

    public static void main(String[] args) {
        Hash hash = new Hash(16);
        hash.add(2);
        hash.add(3);
        hash.add(18);
        hash.add(100);
        hash.add(13);
        System.out.println(hash.count());
        System.out.println("--------------");
        hash.show();
    }
}