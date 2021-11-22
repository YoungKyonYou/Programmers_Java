package InflearnStackQueue;

import java.util.*;

public class CorrectParentheses {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(s);
            else if (!stack.isEmpty())
                stack.pop();
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}