package InflearnStackQueue;
import java.util.*;

public class SteelStick4 {
    public static int ans = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        solution(str);
        System.out.println(ans);
    }

    public static void solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='(')
                stack.push(str.charAt(i));
            else {
                stack.pop();
                if (str.charAt(i - 1) == ')') 
                    ans++;
                else
                    ans+=stack.size();
            }
        }
    }
}