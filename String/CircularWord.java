
import java.util.*;

public class CircularWord {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));

    }

    public static String solution(String str) {
        str = str.toLowerCase();
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            if (str.charAt(lt) == str.charAt(rt)) {
                lt++;
                rt--;
            } else {
                return "NO";
            }
        }
        return "YES";
    }
}