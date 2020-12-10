package datastructure.linked;

/**
 * @Author weimin
 * @Date 2020/10/13 0013 15:51
 * 双向链表
 */
public class DoubleLinked {
    private int size;
    private Node init = new Node("init", 0);

    public boolean isEmpty() {
        return size == 0;
    }
    public int getSize(){
        return size;
    }

    public void addNext(Node node) {
        Node temp = init;
        while (temp.next!=null){
            temp = temp.next;
        }

        temp.next = node;
        node.pre = temp;
        size++;
    }

    public void addPre(Node node) {
        node.pre = init;
        node.next = init.next;
        init.next.pre = node;
        init.next = node;
        size++;

    }

    public void delete(int num){
        if(isEmpty()){
            return;
        }

        for (Node node = init.next;node != null;node = node.next){
            if(node.num == num){
                if(node.next==null){
                    node.pre.next = null;
                    node.pre = null;
                }else {
                    node.next.pre = node.pre;
                    node.pre.next =  node.next;
                }
            }
        }
    }

    public void show(){
        if(isEmpty()){
            throw new RuntimeException("empty!!");
        }else {
            for (Node node = init.next;node!=null;node = node.next){
                System.out.println(node);
            }
        }
    }


    static class Node {
        private Node next;
        private Node pre;
        private String name;
        private Integer num;

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
        DoubleLinked doubleLinked = new DoubleLinked();
        doubleLinked.addNext(new Node("lion",1));
        doubleLinked.addNext(new Node("tiger",2));
        doubleLinked.addNext(new Node("dog",3));
        doubleLinked.addNext(new Node("fish",4));
        doubleLinked.addPre(new Node("cat",0));
        System.out.println(doubleLinked.getSize());
        doubleLinked.show();

        System.out.println("====================");
        doubleLinked.delete(3);
        doubleLinked.show();

        System.out.println("====================");
        doubleLinked.delete(4);
        doubleLinked.show();
    }
}
