package InflearnDFSBFSApplication;
import java.util.*;

public class ShortestPathInTree {
    public static class Node {
        public int data;
        public Node left;
        public Node right;
    }
    public static void main(String[] args) throws Exception {
        Node root=new Node();
        Node n2 = new Node();
        n2.data = 2;
        n2.left = new Node();
        n2.right = new Node();
        n2.left.data = 4;
        n2.right.data = 5;
        root.data = 1;
        root.left = n2;
        Node n3 = new Node();
        n3.left = null;
        n3.right = null;
        root.right = n3;
        solution(root);
    }

    public static int solution(Node node) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node n = q.poll();
                if (n.left == null && n.right == null)
                    return answer;
                if (n.left != null)
                    q.add(n.left);
                if (n.right != null)
                    q.add(n.right);
            }
            answer++;
        }
        System.out.println(answer);
        return 0;

    }
    
}