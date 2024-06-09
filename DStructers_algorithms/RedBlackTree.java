package DStructers_algorithms;//Ksenia Korchagina
import java.util.*;

public class RedBlackTree<Key extends Comparable<Key>> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;
        Node left, right, parent;
        boolean color;

        Node(Key key) {
            this.key = key;
            this.color = RED;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    private Node root;
    private int nodeCount;

    public RedBlackTree() {
        root = null;
        nodeCount = 0;
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null)
            root = y;
        else if (x.key.compareTo(x.parent.key) < 0)
            x.parent.left = y;
        else
            x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != null)
            x.right.parent = y;
        x.parent = y.parent;
        if (y.parent == null)
            root = x;
        else if (y.key.compareTo(y.parent.key) < 0)
            y.parent.left = x;
        else
            y.parent.right = x;
        x.right = y;
        y.parent = x;
    }

    public void rbInsert(Key key) {
        Node z = new Node(key);
        Node y = null;
        Node x = root;

        while (x != null) {
            y = x;
            if (z.key.compareTo(x.key) < 0)
                x = x.left;
            else
                x = x.right;
        }

        z.parent = y;
        if (y == null)
            root = z;
        else if (z.key.compareTo(y.key) < 0)
            y.left = z;
        else
            y.right = z;

        z.left = null;
        z.right = null;
        z.color = RED;
        rbInsertFixup(z);

        nodeCount++;
    }
    private void rbInsertFixup(Node z) {
        while (z.parent != null && z.parent.color == RED) {
            if (z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right;
                if (y != null && y.color == RED) {
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    rightRotate(z.parent.parent);
                }
            } else {
                Node y = z.parent.parent.left;
                if (y != null && y.color == RED) {
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    public void inorder() {
        System.out.println(nodeCount);
        inorder(root);
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            Key leftKey = (node.left != null) ? node.left.key : null;
            Key rightKey = (node.right != null) ? node.right.key : null;
            System.out.println(node.key + " " + (leftKey != null ? leftKey : -1) + " " + (rightKey != null ? rightKey : -1));
            inorder(node.right);
        }
    }

    public Key getRootIndex() {
        return root.key;
    }

    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        Scanner scanner = new Scanner(System.in);
        int amountOfNodes = scanner.nextInt();
        for (int i = 0; i < amountOfNodes; i++) {
            int newNode = scanner.nextInt();
            tree.rbInsert(newNode);
        }

        tree.inorder();
        System.out.println(tree.getRootIndex());
    }
}