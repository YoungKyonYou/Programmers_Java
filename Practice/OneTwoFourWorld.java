package Practice;

import java.util.*;
import java.util.stream.Collectors;

public class OneTwoFourWorld {
    public static void main(String[] args) throws Exception {
        int n = 12;// 424
        String a = solution(n);
        System.out.println("FINAL ANSWER:" + a);
    }

    public static String solution(int n) {
        String[] numbers = { "4", "1", "2" };
        String answer = "";

        int num = n;

        while (num > 0) {
            int remainder = num % 3;
            num /= 3;

            if (remainder == 0)
                num--;

            answer = numbers[remainder] + answer;
            System.out.println("answer:" + answer);
        }

        return answer;
    }
}