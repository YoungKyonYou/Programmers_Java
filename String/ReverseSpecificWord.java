
import java.util.*;

public class ReverseSpecificWord {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));

    }

    public static String solution(String str) {
        String ans = "";
        String rstr = "";
        for (char c : str.toCharArray()) {
            if(Character.isAlphabetic(c))
                rstr += Character.toString(c);
        }
        StringBuilder temp = new StringBuilder(rstr);
        rstr = temp.reverse().toString();
        int idx=0;
        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) 
                ans += rstr.charAt(idx++);
            else 
                ans += Character.toString(c);
        }

        return ans;
    }
}