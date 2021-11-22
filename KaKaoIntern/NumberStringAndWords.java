package KaKaoIntern;

import java.util.*;

public class NumberStringAndWords {
    public enum NUM {
        zero, one, two, three, four, five, six, seven, eight, nine
    };

    public static void main(String[] args) throws Exception {
        String s = "23four5six7";
        int ans = solution(s);
        System.out.println(ans);
    }

    public static int solution(String s) {
        List<String> list = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
                "nine");
        String str = "";
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                str += s.charAt(i);
                if (list.contains(str)) {
                    int num = list.indexOf(str);
                    ans += Integer.toString(num);
                    str = "";
                }
            } else {
                ans += s.charAt(i);
            }
        }
        return Integer.parseInt(ans);
    }
}