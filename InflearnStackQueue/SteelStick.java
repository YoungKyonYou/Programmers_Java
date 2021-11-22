package InflearnStackQueue;
import java.util.*;

public class SteelStick {
    public static int ans = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        solution(stack, str);
        System.out.println(ans);
    }

    public static void solution(Stack<Character> stack, String str) {
        int cnt = 0;
        int pcnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
                pcnt = 0;
            } else {
                pcnt++;
                stack.push(')');
                if (pcnt == 2) {
                    stack.pop();
                    while (stack.peek() == ')') {
                        stack.pop();
                        stack.pop();
                        cnt++;
                    }
                    stack.pop();
                    ans += (cnt + 1);
                    for (int j = 0; j < cnt; j++) {
                        stack.add('(');
                        stack.add(')');
                    }
                    pcnt = 1;
                    cnt = 0;
                }
            }
        }
    }
}