
import java.util.*;

public class dartgame {
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        String dart = "1S2D*3T*";
        System.out.println(solution(dart));
    }

    public static int solution(String dartResult) {
        int answer = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            int temp;
            if (dartResult.charAt(i) == '1') {
                if (i + 1 < dartResult.length()) {
                    if (i < dartResult.length() && dartResult.charAt(i + 1) == '0') {
                        stack.push(10);
                        i++;
                    } else {
                        stack.push(1);
                    }
                    continue;
                }
            }
            if (dartResult.charAt(i) == 'S') {
                temp = stack.pop();
                temp = (int) Math.pow(temp, 1);
                stack.push(temp);
                continue;
            } else if (dartResult.charAt(i) == 'D') {
                temp = stack.pop();
                temp = (int) Math.pow(temp, 2);
                stack.push(temp);
                continue;
            } else if (dartResult.charAt(i) == 'T') {
                temp = stack.pop();
                temp = (int) Math.pow(temp, 3);
                stack.push(temp);
                continue;
            } else if (dartResult.charAt(i) == '*') {
                if (stack.size() >= 2) {
                    int t1 = stack.pop();
                    int t2 = stack.pop();
                    stack.push(t2 * 2);
                    stack.push(t1 * 2);
                } else {
                    int t3 = stack.pop();
                    stack.push(t3 * 2);
                }
                continue;
            } else if (dartResult.charAt(i) == '#') {
                int t4 = stack.pop();
                stack.push(t4 * (-1));
                continue;
            }
            stack.push(Character.getNumericValue(dartResult.charAt(i)));

        }
        while (!stack.isEmpty()) {
            int tt = stack.pop();
            System.out.print(tt + " ");
            answer += tt;
        }
        System.out.println();
        return answer;
    }
}