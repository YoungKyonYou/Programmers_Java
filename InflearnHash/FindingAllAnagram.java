package InflearnHash;
import java.util.*;
public class  FindingAllAnagram{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(solution(str1, str2));
    }
    public static int solution(String s1, String s2) {
        int ans = 1;
        int lt = 0, rt = s2.length() - 1;
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : s2.toCharArray())
            hash.put(c, hash.getOrDefault(c, 0)+1);
        for (int i = 0; i < s2.length(); i++) 
            if (hash.containsKey(s1.charAt(i))) 
                hash.put(s1.charAt(i), hash.get(s1.charAt(i))-1);
        if (!hash.containsValue(0))
            ans = 0;
        for (int i = rt; i < s1.length()-1; i++) {
            if (hash.containsKey(s1.charAt(lt)))
                hash.put(s1.charAt(lt), hash.get(s1.charAt(lt))+1);
            lt++;
            if (hash.containsKey(s1.charAt(lt))) 
                hash.put(s1.charAt(lt), hash.get(s1.charAt(lt)) + 1);
            rt++;
            if (hash.containsKey(s1.charAt(rt))) 
                hash.put(s1.charAt(rt), hash.get(s1.charAt(rt)) - 1);
            if (!hash.containsValue(0)) {
                
            }
            else
                ans++;
        }
        return ans;
    }
}