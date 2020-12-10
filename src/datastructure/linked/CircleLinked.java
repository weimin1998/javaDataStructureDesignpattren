package datastructure.linked;

/**
 * @Author weimin
 * @Date 2020/10/13 0013 16:50
 * 环形链表
 */
public class CircleLinked {
    private Node init;
    private int size;


    public CircleLinked(int num) {
        for (int i = 1; i <= num; i++) {
            add(new Node(i));
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Node node) {
        if (isEmpty()) {
            init = node;
            init.next = init;
        } else {
            Node temp = init;
            while (temp.next != init) {
                temp = temp.next;
            }
            temp.next = node;
            node.next = init;
        }
        size++;
    }

    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("empty!!");
        }
        if (size == 1) {
            System.out.println(init);
        } else {
            Node temp = init;
            for (int i = 1; i <= size; i++) {
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }
    public void delete(int num){
        if(isEmpty()){
            throw new RuntimeException("empty!!");
        }
        if(size==1){
            if(init.num == num){
                init =null;
                size--;
                return;
            }
        }
        Node temp = init;
        for (int i = 1;i<=size;i++){
            if(temp.next.num == num){
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }

    }

    // 约瑟夫
    public void joseph(int start,int number){
        Node startNode = null;
        Node temp = init;
        for(int i = 1;i<=size;i++){
            if(temp.num == start){
                startNode = temp;
            }
            temp = temp.next;
        }
        int n = 0;
        for (Node node = startNode; !isEmpty(); node = node.next){
            assert node!=null;
            n++;
            if(n%number==0){
                System.out.println(node.num);
                delete(node.num);
            }
        }
    }


    static class Node {

        private Integer num;
        private Node next;

        public Node(Integer num) {
            this.num = num;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    '}';
        }
    }

    public static void main(String[] args) {
        CircleLinked circleLinked = new CircleLinked(7);
        circleLinked.show();
        //System.out.println(circleLinked.size);
        /*circleLinked.delete(3);
        circleLinked.show();
        System.out.println(circleLinked.size);*/

        circleLinked.joseph(4,3);
    }
}
