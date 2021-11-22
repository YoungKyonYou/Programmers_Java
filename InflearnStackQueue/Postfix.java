package InflearnStackQueue;
import java.util.*;


public class Postfix {
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
        return;
    }

    public static int solution(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 49 && str.charAt(i) <= 57) {
                stack.add(Character.getNumericValue(str.charAt(i)));
            } else {
                int n2 = stack.pop();
                int n1 = stack.pop();
                int temp = 0;
                switch (str.charAt(i)) {
                    case '+':
                        temp = n1 + n2;
                        break;
                    case '-':
                        temp = n1 - n2;
                        break;
                    case '*':
                        temp = n1 * n2;
                        break;
                    case '/':
                        temp = n1 / n2;
                        break;
                }
                stack.add(temp);
            }
        }
        return stack.peek();
    }
}