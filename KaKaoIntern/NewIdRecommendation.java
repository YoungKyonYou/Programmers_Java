package KaKaoIntern;

import java.util.*;

public class NewIdRecommendation {
    public static void main(String[] args) throws Exception {
        String new_id = "b";
        String a = "";
        a = solution(new_id);
        System.out.println(a);
    }

    public static String solution(String new_id) {

        StringBuilder sb = new StringBuilder(new_id);

        // 1단계
        sb = new StringBuilder(sb.toString().toLowerCase());
        // 2단계
        for (int i = 0; i < sb.length(); i++) {
            if (!(sb.charAt(i) == '-' || sb.charAt(i) == '_' || sb.charAt(i) == '.'
                    || (sb.charAt(i) >= 48 && sb.charAt(i) <= 57) || (sb.charAt(i) >= 97 && sb.charAt(i) <= 122))) {
                sb = new StringBuilder(sb.substring(0, i) + sb.substring(i + 1, sb.length()));
                i--;
                continue;
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '.' && sb.length() > 1) {
                if (sb.length() - 1 != i && sb.charAt(i + 1) == '.') {
                    sb = new StringBuilder(sb.substring(0, i) + sb.substring(i + 1, sb.length()));
                    i--;
                    continue;
                } else if (sb.length() - 1 == i && sb.charAt(i - 1) == '.') {
                    sb = new StringBuilder(sb.substring(0, i - 1) + sb.substring(i, sb.length()));
                    i--;
                    continue;
                }
            }
        }
        // 4단계
        if (sb.charAt(0) == '.')
            sb = new StringBuilder(sb.substring(1, sb.length()));
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '.')
            sb = new StringBuilder(sb.substring(0, sb.length() - 1));
        // 5단계
        if (sb.length() == 0)
            sb.append("aaa");

        // 6단계
        if (sb.length() > 15) {
            sb = new StringBuilder(sb.substring(0, 15));
        }
        // 4단계
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '.')
            sb = new StringBuilder(sb.substring(0, sb.length() - 1));
        // 7단계

        if (sb.length() < 3) {
            if (sb.length() == 1) {
                sb.append(sb.charAt(0));
                sb.append(sb.charAt(0));
            } else {
                sb.append(sb.charAt(1));
            }
        }

        return sb.toString();
    }

}