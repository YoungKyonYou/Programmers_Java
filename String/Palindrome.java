
import java.util.*;

public class Palindrome {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));

    }

    public static String solution(String str) {
        str = str.toLowerCase().replaceAll("[^a-zA-z]", "");
        String temp = new StringBuilder(str).reverse().toString();
        if(str.equals(temp)){
            return "YES";
        }
        
        return "NO";
    }
}