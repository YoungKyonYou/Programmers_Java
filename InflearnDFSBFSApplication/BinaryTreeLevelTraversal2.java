package InflearnDFSBFSApplication;
import java.util.*;

public class BinaryTreeLevelTraversal2 {
    static public Queue<Tree> q;
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
        q = new LinkedList<>();
        q.add(root);
        solution(q);
        
    }

    public static void solution(Queue<Tree> q) {
       // System.out.print(q.peek().node+" ");
        while (!q.isEmpty()) {
            Tree n = q.poll();
            System.out.print(n.node + " ");
            if(n.left!=null)
                q.add(n.left);
            if(n.right!=null)
                q.add(n.right);
        }
    }
}