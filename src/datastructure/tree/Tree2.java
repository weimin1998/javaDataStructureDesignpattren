package datastructure.tree;

/**
 * @Author weimin
 * @Date 2020/10/16 0016 15:16
 * 线索化二叉树
 */
public class Tree2 {
    private Node root;
    private Node pre;

    public Tree2(Node root) {
        this.root = root;
    }

    public static void main(String[] args) {
        Tree2 tree = new Tree2(new Node(7));
        tree.add(new Node(5), tree.root);
        tree.add(new Node(9), tree.root);
        tree.add(new Node(3), tree.root);
        tree.add(new Node(6), tree.root);
        tree.add(new Node(8), tree.root);


        //3 5 6 7 8 9
        tree.mid(tree.root);

        System.out.println("=============");
        tree.xiansuohua(tree.root);
        System.out.println(tree.root.left.right.right);//7
        System.out.println(tree.root.left.right.left);//5
        System.out.println(tree.root.right.left.left);//7
        System.out.println(tree.root.right.left.right);//9
        System.out.println(tree.root.left.left.right);//5
        System.out.println("================");

        tree.xiansuohuabianli(tree.root);
        // 7 5 3 6 9 8
        //tree.pre(tree.root);

    }

    public void add(Node node, Node root) {
        if (node.data > root.data) {
            if (root.right == null) {
                root.right = node;
            } else {
                add(node, root.right);
            }
        }

        if (node.data < root.data) {
            if (root.left == null) {
                root.left = node;
            } else {
                add(node, root.left);
            }
        }

    }

    // 前序遍历
    public void pre(Node root) {
        System.out.println(root.data);
        if (root.left != null) {
            pre(root.left);
        }
        if (root.right != null) {
            pre(root.right);
        }

    }

    // 中序遍历
    public void mid(Node root) {
        if (root.left != null) {
            mid(root.left);
        }
        System.out.println(root.data);
        if (root.right != null) {
            mid(root.right);
        }
    }
    public void xiansuohua(Node node){
        if(node==null){
            return;
        }

        xiansuohua(node.left);
        //
        if(node.left==null){
            node.left=pre;
            node.leftType=1;
        }
        if (pre!=null&&pre.right==null){
            pre.right = node;
            pre.rightType = 1;
        }
        pre = node;
        //
        xiansuohua(node.right);

    }

    public void xiansuohuabianli(Node node){
        while (node!=null){
            while (node.leftType==0){
                node = node.left;
            }

            System.out.println(node.data);
            while (node.rightType==1){
                node = node.right;
                System.out.println(node.data);
            }
            node = node.right;
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        //这两个属性，0为指向子树，1为前驱或后继
        int leftType;
        int rightType;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
