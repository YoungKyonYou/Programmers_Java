package InflearnHash;
import java.util.*;
public class  Anagram{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(solution(str1, str2));
    }
    public static String solution(String s1, String s2) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : s1.toCharArray())
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        for (char c : s2.toCharArray()) {
            if (!hash.containsKey(c) || hash.get(c) == 0)
                return "NO";
            hash.put(c, hash.get(c) - 1);
        }
        return "YES";
    }
}