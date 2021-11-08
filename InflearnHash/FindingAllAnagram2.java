package InflearnHash;
import java.util.*;
public class  FindingAllAnagram2{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(solution(str1, str2));
    }
    public static int solution(String s1, String s2) {
        HashMap<Character, Integer> hash1 = new HashMap<>();
        HashMap<Character, Integer> hash2 = new HashMap<>();
        int ans=0;
        int lt = 0;
        for(int i=0;i<s2.length();i++)
            hash2.put(s2.charAt(i), hash2.getOrDefault(s2.charAt(i), 0) + 1);
        for(int i=0;i<s2.length()-1;i++)
            hash1.put(s1.charAt(i), hash1.getOrDefault(s1.charAt(i), 0) + 1);
        for (int i = s2.length() - 1; i < s1.length(); i++) {
            hash1.put(s1.charAt(i), hash1.getOrDefault(s1.charAt(i), 0) + 1);
            if (hash1.equals(hash2))
                ans++;
            hash1.put(s1.charAt(lt), hash1.get(s1.charAt(lt)) - 1);
            if (hash1.get(s1.charAt(lt)) == 0)
                hash1.remove(s1.charAt(lt));
            lt++;
        }
        return ans;
    }
}