package KakaoBlindRecruit;

import java.util.*;

public class StringCompression {

    public static void main(String[] args) throws Exception {
        // String s = "ababcdcdababcdcd";
        // String s = "aaaaaaaaaab";
        //String s = "aabbaccc";
        // String s = "ababcdcdababcdcd";
         String s =
         "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        int ans = solution(s);
        System.out.println("FINAL ANSWER:" + ans);
    }

    public static int solution(String s) {
        int answer = s.length();
        int start = 1;
        String unit="";
        for (int i = 0; i < s.length() / 2 + 1; i++) {
            int num = 0, cnt = 0;
            int temp= s.length();
            for (int j = 0; j < s.length(); j += start) {
                if (j + start <= s.length())
                    unit = s.substring(j, j + start);
                if (start * 2 + j <= s.length() && s.substring(start + j, start * 2 + j).equals(unit)) {
                    cnt += start;
                    num++;
                } else {
                    if (cnt != 0) {
                        num++;
                        num = (int) Math.log10(num);
                        temp -= (cnt - 1) - num;
                    }
                    num = 0;
                    cnt = 0;
                }
            }
            answer = Math.min(answer, temp);
            start++;
        }
        return answer;
    }
}