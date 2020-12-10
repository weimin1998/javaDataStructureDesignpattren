package datastructure;

/**
 * @Author weimin
 * @Date 2020/10/12 0012 13:17
 * 环形队列
 */
public class CircleQueue {
    private int[] data;
    private int head;
    private int tail;
    private int maxsize;

    public CircleQueue(int maxsize) {
        this.maxsize = maxsize;
        data = new int[maxsize];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % maxsize == head;
    }

    public void add(int i) {
        if (isFull()) {
            throw new RuntimeException("queue is full");
        } else {
            data[tail] = i;
            tail = (tail + 1) % maxsize;
        }
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        } else {
            int datum = data[head];
            head = (head + 1) % maxsize;
            return datum;
        }
    }

    public int size() {
        return (tail - head + maxsize) % maxsize;
    }

    public void show(){
        if(isEmpty()){
            throw new RuntimeException("queue is empty");
        }else {
            /*for (int i:data){
                System.out.println(i);
            }*/
            for (int i = 0; i<size();i++){
                System.out.println(data[i+head]);
            }
        }
    }

    public static void main(String[] args) {
        /*CircleQueue circleQueue = new CircleQueue(8);
        System.out.println(circleQueue.isEmpty());
        System.out.println(circleQueue.isFull());
        circleQueue.add(1);
        circleQueue.add(2);
        circleQueue.add(3);
        circleQueue.add(4);
        circleQueue.add(5);
        circleQueue.add(6);
        circleQueue.add(7);
        System.out.println(circleQueue.size());
        System.out.println(circleQueue.isFull());
        System.out.println(circleQueue.get());
        System.out.println(circleQueue.size());
        circleQueue.add(8);
        System.out.println("----------------");
        circleQueue.show();
        System.out.println("------------");
        System.out.println(circleQueue.size());*/

        CircleQueue circleQueue = new CircleQueue(5);
        circleQueue.add(1);
        circleQueue.add(2);
        circleQueue.add(3);
        circleQueue.add(4);
        System.out.println(circleQueue.size());
        System.out.println("----------------");
        circleQueue.show();
        System.out.println("------------");
        circleQueue.get();
        circleQueue.add(5);
        circleQueue.show();


    }
}
