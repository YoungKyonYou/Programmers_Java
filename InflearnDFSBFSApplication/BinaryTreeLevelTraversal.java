package InflearnDFSBFSApplication;
import java.util.*;

public class BinaryTreeLevelTraversal {
    static public class Tree {
        public int node;
        public Tree left=null;
        public Tree right=null;

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
        System.out.print(root.node + " ");
        solution(root);
        
    }
    public static void solution(Tree node) {
        if (node.left!=null && node.right!=null) {
            System.out.print(node.left.node+" "+node.right.node+" ");
            solution(node.left);
            solution(node.right);
        }
    }
}