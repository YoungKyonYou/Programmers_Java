package InflearnDFSBFSApplication;
import java.util.*;

public class BinaryTreeTraversal {
    static public class Tree {
        public int node;
        public Tree left;
        public Tree right;

        public Tree(int node) {
            this.node = node;
        }

        public void setLeft(Tree left) {
            this.left = left;
        }

        public void setRight(Tree right) {
            this.right = right;
        }
    }
    public static void main(String[] args) throws Exception {
        Tree root = new Tree(1);
        Tree node1 = new Tree(2);
        Tree node2 = new Tree(3);
        Tree node3 = new Tree(4);
        Tree node4 = new Tree(5);
        Tree node5 = new Tree(6);
        Tree node6 = new Tree(7);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

    public static void preOrder(Tree node) {
        if (node != null) {
            System.out.print(node.node + " ");
            preOrder(node.left);
            preOrder(node.right);   
        }
    }
    
    public static void inOrder(Tree node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.node + " ");
            inOrder(node.right);
        }
    }
    
    public static void postOrder(Tree node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.node + " ");
        }
    }
}