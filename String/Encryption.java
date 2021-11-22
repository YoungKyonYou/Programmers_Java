
import java.util.*;

public class Encryption {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(n, str));

    }

    public static String solution(int n, String str) {
        String ans = "";
        int cnt=1;
        String s="";
        for (int i = 0; i < n; i++) {
            s = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int temp = Integer.parseInt(s, 2);
            ans += (char) temp;
            str = str.substring(7);
        }
        return ans;
    }
}