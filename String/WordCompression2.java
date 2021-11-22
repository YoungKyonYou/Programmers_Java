
import java.util.*;

public class WordCompression2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));

    }

    public static String solution(String str) {
        String ans = "";
        int cnt = 1;
        str = str + " ";
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                cnt++;
            } else {
                ans += str.charAt(i);
                if(cnt!=1)
                    ans += String.valueOf(cnt);
                cnt = 1;
            }
        }
        return ans;
    }
}