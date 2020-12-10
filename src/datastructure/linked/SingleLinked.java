package datastructure.linked;

import java.util.ArrayList;

/**
 * @Author weimin
 * @Date 2020/10/12 0012 14:36
 * 单向链表
 */
public class SingleLinked {

    private Node head = new Node("头节点", 0);
    private Node tail = head;
    private int size;

    public boolean isEmpty() {
        return head.next == null;
    }

    public int size() {
        return size;
    }

    public void add(Node node) {
        if (isEmpty()) {
            head.next = node;
        } else {
            tail.next = node;
        }
        tail = node;
        tail.next = null;
        size++;
    }

    // 获取对应num的节点
    public Node get(int num) {
        for (Node node = head.next; node != null; node = node.next) {
            if (node.num == num) {
                return node;
            }
        }
        return null;
    }

    public void delete(int num) {
        if (isEmpty()) {
            throw new RuntimeException("empty!!");
        } else {
            for (Node node = head; node != null; node = node.next) {
                if (node.next.num == num) {
                    node.next = node.next.next;
                    size--;
                    return;
                }
            }
        }
    }

    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("empty!!");
        } else {
            for (Node node = head.next; node != null; node = node.next) {
                System.out.println(node);
            }
        }
    }

    // 获取倒数第i个节点
    public Node get1(int i) {
        int n = 0;
        for (Node node = head.next; node != null; node = node.next) {
            n++;
            if (i == size - n + 1) {
                return node;
            }
        }
        return null;
    }

    // 获取正数第i个节点
    public Node geti(int i) {
        int n = 0;
        for (Node node = head.next; node != null; node = node.next) {
            n++;
            if (n == i) {
                return node;
            }
        }
        return null;
    }

    // 反转
    public static SingleLinked reserve(SingleLinked singleLinked) {
        SingleLinked result = new SingleLinked();
        for (int i = 1; i <= singleLinked.size(); i++) {
            result.add(singleLinked.get1(i));
        }
        result.tail.next = null;
        return result;
    }

    // 按序添加
    public void addByNum(Node data) {
        if (isEmpty()) {
            add(data);
        } else {
            int n = 0;
            for (Node node = head.next; node != null; node = node.next) {
                n++;
                if (data.num.equals(node.num)) {
                    System.out.println("该序号已经存在");
                    return;
                }
                if (node.num > data.num) {
                    data.next = node;
                    if (geti(n - 1) != null) {
                        geti(n - 1).next = data;
                    } else {
                        head.next = data;
                    }
                    size++;
                    return;
                }
            }
            add(data);
        }

    }

    // 排序
    public static SingleLinked sort(SingleLinked singleLinked) {
        SingleLinked result = new SingleLinked();
        for (int i = 1; i <= singleLinked.size(); i++) {
            result.addByNum(singleLinked.get1(i));
        }
        return result;
    }

    // 合并两个链表，并且合并后有序
    public static SingleLinked merge(SingleLinked singleLinked1, SingleLinked singleLinked2) {
        SingleLinked result = new SingleLinked();

        for (int i = 1; i <= singleLinked1.size(); i++) {
            result.addByNum(singleLinked1.get1(i));
        }

        for (int i = 1; i <= singleLinked2.size(); i++) {
            result.addByNum(singleLinked2.get1(i));
        }

        return result;
    }


    static class Node {
        private String name;
        private Integer num;
        private Node next;

        public Node(String name, Integer num) {
            this.name = name;
            this.num = num;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", num=" + num +
                    '}';
        }
    }


    public static void main(String[] args) {
        /*SingleLinked singleLinked = new SingleLinked();
        singleLinked.add(new Node("lion", 1));
        singleLinked.add(new Node("tiger", 2));
        singleLinked.add(new Node("cat", 3));
        singleLinked.add(new Node("dog", 4));
        singleLinked.add(new Node("fish", 5));
        singleLinked.add(new Node("bird", 8));
        singleLinked.add(new Node("snake", 13));
        singleLinked.show();

        System.out.println("------------------");
        singleLinked.addByNum(new Node("mouse",9));
        singleLinked.addByNum(new Node("house",6));
        singleLinked.addByNum(new Node("test",100));
        singleLinked.show();
        System.out.println("----------------------");
        SingleLinked.reserve(singleLinked).show();*/

        /*SingleLinked singleLinked = new SingleLinked();
        singleLinked.add(new Node("lion", 1));
        singleLinked.add(new Node("dog", 4));
        singleLinked.add(new Node("tiger", 2));
        singleLinked.add(new Node("bird", 8));
        singleLinked.add(new Node("fish", 5));
        singleLinked.add(new Node("cat", 3));
        singleLinked.add(new Node("snake", 13));
        singleLinked.show();
        System.out.println("------------------");
        singleLinked.addByNum(new Node("Test",100));

        singleLinked.show();

        System.out.println("=====================");
        SingleLinked sort = SingleLinked.sort(singleLinked);
        sort.show();*/


        SingleLinked singleLinked = new SingleLinked();
        singleLinked.add(new Node("lion", 1));
        singleLinked.add(new Node("tiger", 2));
        singleLinked.add(new Node("cat", 3));
        singleLinked.add(new Node("dog", 4));
        singleLinked.add(new Node("fish", 5));
        singleLinked.add(new Node("bird", 8));
        singleLinked.add(new Node("snake", 13));
        singleLinked.add(new Node("test", 100));

        SingleLinked singleLinked1 = new SingleLinked();
        singleLinked1.add(new Node("adad", 7));
        singleLinked1.add(new Node("FHDFG", 14));
        singleLinked1.add(new Node("CWF", 22));
        singleLinked1.add(new Node("ndasdf", 35));
        singleLinked1.add(new Node("wfvasf", 62));

        SingleLinked merge = SingleLinked.merge(singleLinked1, singleLinked);
        merge.show();
        System.out.println(merge.size());

        System.out.println("==========================");
        merge.delete(8);
        merge.show();
        System.out.println(merge.size());
    }
}
