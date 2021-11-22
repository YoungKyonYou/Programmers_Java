package InflearnDFSBFSApplication;
import java.util.*;

public class ShortestPathInTree2 {
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
        int answer = 0;
        System.out.println(solution(root,answer));
    }

    public static int solution(Node node,int answer) {
        answer++;
        if(node.left==null && node.right==null)
            return answer;
        else
            return Math.min(solution(node.left, answer + 1), solution(node.right, answer + 1));
    }
    
}