package InflearnStackQueue;
import java.util.*;

public class ParenthesesRemove {
    public static Stack<Character> stack = new Stack<>();
    public static String ans = "";
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        solution(s);
        System.out.println(ans);
    }

    public static void solution(String s) {
        for (char c : s.toCharArray()) {
            if (c == ')') {
                while (stack.peek() != '(') 
                    stack.pop();
                stack.pop();
            } else 
                stack.push(c);
        }
        while (!stack.isEmpty()) 
            ans=stack.pop()+ans;
    }
}