package datastructure.tree;

/**
 * @Author weimin
 * @Date 2020/10/15 0015 18:05
 */
public class Tree {

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }


    public static void main(String[] args) {
        /*Tree tree = new Tree(new Node(7));
        tree.add(new Node(5), tree.root);
        tree.add(new Node(9), tree.root);
        tree.add(new Node(3), tree.root);
        tree.add(new Node(6), tree.root);
        tree.add(new Node(8), tree.root);
        tree.add(new Node(10), tree.root);
        tree.add(new Node(4), tree.root);*/
        /*Tree tree = new Tree(new Node(4));
        tree.add(new Node(3),tree.root);
        tree.add(new Node(6),tree.root);
        tree.add(new Node(5),tree.root);
        tree.add(new Node(7),tree.root);
        tree.add(new Node(8),tree.root);*/

        /*Tree tree = new Tree(new Node(10));
        tree.add(new Node(12),tree.root);
        tree.add(new Node(8),tree.root);
        tree.add(new Node(9),tree.root);
        tree.add(new Node(7),tree.root);
        tree.add(new Node(6),tree.root);*/

        Tree tree = new Tree(new Node(10));
        tree.add(new Node(11),tree.root);
        tree.add(new Node(7),tree.root);
        tree.add(new Node(6),tree.root);
        tree.add(new Node(8),tree.root);
        tree.add(new Node(9),tree.root);
        /*Node root = tree.root;
        System.out.println(root);
        System.out.println(root.right);
        System.out.println(root.right.left);
        System.out.println(root.right.right);


        System.out.println(root.left);
        System.out.println(root.left.left);
        System.out.println(root.left.right);*/

        /*tree.pre(tree.root);
        System.out.println("==================");
        tree.mid(tree.root);
        System.out.println("==================");
        tree.behind(tree.root);
        System.out.println("==================");*/

        /*System.out.println(tree.preFind(tree.root, 10));
        System.out.println("================");
        System.out.println(tree.midfind(tree.root, 8));
        System.out.println("================");
        System.out.println(tree.behindFind(tree.root, 7));*/



        /*tree.pre(tree.root);
        System.out.println("=============");
        tree.delete(tree.root,6);
        tree.pre(tree.root);
        System.out.println("=============");
        tree.delete(tree.root,11);
        tree.pre(tree.root);
        System.out.println("=============");
        tree.delete(tree.root,9);
        tree.pre(tree.root);*/


        //tree.mid(tree.root);
        tree.mid(tree.root);

        System.out.println("树的高度"+height(tree.root));
        System.out.println("左子树"+height(tree.root.left));
        System.out.println("右子树"+height(tree.root.right));
        System.out.println("==============");
        /*tree.leftRotate();
        tree.mid(tree.root);
        System.out.println("树的高度"+height(tree.root));
        System.out.println("左子树"+height(tree.root.left));
        System.out.println("右子树"+height(tree.root.right));*/
    }


    // 向树上添加节点
    // 这样添加的话，就是一颗二叉排序树（二叉搜索树、二叉查找树）
    // 中序遍历，就是一个有序的
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
        //  这里有问题，节点多就不好使了，先放下
        if(root.left!=null&&root.right!=null&&height(root.right)-height(root.left)>1){
            if(height(root.right.left)>height(root.right.right)){
                rightRotate(root.right);
            }
            leftRotate(root);
            return;
        }

        if(root.left!=null&&root.right!=null&&height(root.left)-height(root.right)>1){
            if(height(root.left.right)>height(root.left.left)){
                leftRotate(root.left);
            }
            rightRotate(root);
        }
    }

    // 左旋
    private void leftRotate(Node root){
        Node node = new Node(root.data);
        node.left = root.left;
        node.right = root.right.left;
        root.data = root.right.data;
        root.right = root.right.right;
        root.left = node;
    }
    // 右旋
    private void rightRotate(Node root){
        Node node = new Node(root.data);
        node.right = root.right;
        node.left = root.left.right;
        root.data = root.left.data;
        root.left = root.left.left;
        root.right = node;
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

    // 后序遍历
    public void behind(Node root) {
        if (root.left != null) {
            behind(root.left);
        }
        if (root.right != null) {
            behind(root.right);
        }
        System.out.println(root.data);
    }

    // 前序查找
    public Node preFind(Node root, int value) {
        if (root.data == value) {
            return root;
        }
        Node result = null;

        if (root.left != null) {
            result = preFind(root.left, value);
        }
        if (result != null) {
            return result;
        }
        if (root.right != null) {
            result = preFind(root.right, value);
        }
        if (result != null) {
            return result;
        }


        return result;


    }

    // 中序查找
    public Node midfind(Node root, int value) {
        Node result = null;
        if (root.left != null) {
            result = midfind(root.left, value);
        }
        if (result != null) {
            return result;
        }
        if (root.data == value) {
            return root;
        }
        if (root.right != null) {
            result = preFind(root.right, value);
        }
        if (result != null) {
            return result;
        }

        return result;
    }

    // 后序查找
    public Node behindFind(Node root, int value) {
        Node result = null;
        if (root.left != null) {
            result = preFind(root.left, value);
        }
        if (result != null) {
            return result;
        }
        if (root.right != null) {
            result = preFind(root.right, value);
        }
        if (result != null) {
            return result;
        }

        if (root.data == value) {
            return root;
        }
        return result;
    }

    // 删除节点，如果有子树也一块删了
    public void delete(Node root, int value) {

        if (root.left != null && root.left.data == value) {
            root.left = null;
            return;
        }
        if (root.right != null && root.right.data == value) {
            root.right = null;
            return;
        }

        if (root.left != null) {
            delete(root.left, value);
        }
        if (root.right != null) {
            delete(root.right, value);
        }

    }

    // 只删除一个节点，保留子树
    public void deleteOne(Node root, int value) {
        if (root.data == value) {

            Node node = root.left;
            while (node.right != null) {
                node = node.right;
            }
            delete(root, node.data);
            root.data = node.data;
        }

        if (root.left != null) {
            if (root.left.data == value) {
                Node target = root.left;
                // 删除的是叶子节点
                if (target.left == null && target.right == null) {
                    root.left = null;
                } else if (target.left != null && target.right == null) {
                    //有左子节点，没有右子节点
                    root.left = target.left;
                } else if (target.left == null && target.right != null) {
                    root.left = target.right;
                } else {
                    // 左右子节点都有
                    Node node = target;
                    while (target.left != null) {
                        target = target.left;
                    }
                    delete(root, target.data);
                    node.data = target.data;
                }
            }
        }

        if (root.right != null) {
            if (root.right.data == value) {
                Node target = root.right;
                // 删除的是叶子节点
                if (target.left == null && target.right == null) {
                    root.right = null;
                } else if (target.left != null && target.right == null) {
                    //有左子节点，没有右子节点
                    root.right = target.left;
                } else if (target.left == null && target.right != null) {
                    root.right = target.right;
                } else {
                    // 左右子节点都有
                    Node node = target;
                    while (target.left != null) {
                        target = target.left;
                    }
                    delete(root, target.data);
                    node.data = target.data;
                }
            }
        }


        if (root.left != null) {
            deleteOne(root.left, value);
        }
        if (root.right != null) {
            deleteOne(root.right, value);
        }
    }

    // 返回树的高度
    public static int height(Node root) {
        return Math.max(root.left == null ? 0 : height(root.left), root.right == null ? 0 : height(root.right)) + 1;
    }

    static class Node {
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
    }
}
