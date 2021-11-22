package KaKaoIntern;

import java.util.*;

public class NumberStringAndWords2 {
    public enum NUM {
        zero, one, two, three, four, five, six, seven, eight, nine
    };

    public static void main(String[] args) throws Exception {
        String s = "23four5six7";
        int ans = solution(s);
        System.out.println(ans);
    }

    public static int solution(String s) {
        String[] digits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        String[] alphabets = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(alphabets[i], digits[i]);
        }

        return Integer.parseInt(s);
    }
}