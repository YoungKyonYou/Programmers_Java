
import java.util.*;
public class  UpperLowerTransform{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        System.out.println(solution(N));
        
    }

    public static String solution(String N) {
        String ans = "";
        for (char c : N.toCharArray()) {
            if (Character.isUpperCase(c)) 
                ans += Character.toLowerCase(c);
            else
                ans += Character.toUpperCase(c);
        }
        return ans;
    }
}