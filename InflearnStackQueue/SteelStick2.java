package InflearnStackQueue;
import java.util.*;

public class SteelStick2 {
    public static int ans = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        solution(stack, str);
        System.out.println(ans);
    }

    public static void solution(Stack<Character> stack, String str) {
        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                flag = 1;
                stack.push(str.charAt(i));
            } else {
                if (flag == 1) {
                    flag = 0;
                    stack.pop();
                    ans += stack.size();
                } else {
                    stack.pop();
                    ans++;
                }
            }         
        }
    }
}