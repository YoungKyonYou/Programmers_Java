
import java.util.*;

public class WordCompression {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));

    }

    public static String solution(String str) {
        String ans = "";
        int cnt = 1;
        ans += Character.toString(str.charAt(0));
        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                cnt++;
            } else {
                if (cnt != 1)
                    ans += Integer.toString(cnt);
                ans += Character.toString(str.charAt(i));
                c = str.charAt(i);
                cnt = 1;
            }
        }
        if (cnt != 1) {
            ans += Integer.toString(cnt);
        }
        return ans;
    }
}