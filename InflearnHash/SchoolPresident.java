package InflearnHash;
import java.util.*;

public class SchoolPresident {
    public static Character c;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        HashMap<Character, Integer> hash = new HashMap<>();
        String str = sc.nextLine();
        for (int i = 0; i < N; i++) {
            if (!hash.isEmpty() && hash.containsKey(str.charAt(i))) {
                int temp = hash.get(str.charAt(i));
                hash.put(str.charAt(i), temp + 1);
            } else
                hash.put(str.charAt(i), 1);
        }
        int temp = 0;
        for (HashMap.Entry<Character, Integer> map : hash.entrySet()) {
            if (temp < map.getValue()) {
                temp = map.getValue();
                c = map.getKey();
            }
        }
        System.out.println(c);
    }
}