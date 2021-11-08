package InflearnHash;
import java.util.*;

public class SchoolPresident2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        HashMap<Character, Integer> hash = new HashMap<>();
        System.out.println(solution(hash, str));
    }

    public static char solution(HashMap<Character, Integer> hash, String str) {
        for (char c : str.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        int max = -1;
        char ans=0;
        for (char c : hash.keySet()) {
            if (hash.get(c) > max) {
                max = hash.get(c);
                ans = c;
            }
        }
        return ans;
    }
}