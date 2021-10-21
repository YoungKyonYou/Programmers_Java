package InflearnHash;
import java.util.*;
public class Anagram2 {
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
        for (char c : s2.toCharArray())
            hash.put(c, hash.getOrDefault(c,-1) - 1);
        for (char c : hash.keySet())
            if (hash.get(c) != 0)
                return "NO";
        return "YES";
    }
}
