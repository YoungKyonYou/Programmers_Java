package InflearnStackQueue;
import java.util.*;

public class SteelStick2 {
    public static int ans = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }

    public static int solution(String str) {
        int cnt = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                stack.push('(');
            else {
                stack.pop();
                if (str.charAt(i - 1) == '(')
                    cnt += stack.size();
                else
                    cnt++;
            }
        }
        return cnt;
    }
}