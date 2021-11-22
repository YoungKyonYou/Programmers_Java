
import java.util.*;
public class Tuple2{
    public static void main(String[] args) throws Exception {
        String str = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        int[] list = solution(str);
        for (int a : list) {
            System.out.print(a + " ");
        }
    }

    public static int[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        String ss = s.replaceAll("[{}]", "")+ ",";
        String str = "";
        for (int i = 0; i < ss.length(); i++) {
            if (ss.charAt(i) != ',') {
                str += Character.toString(ss.charAt(i));
            } else {
                map.put(Integer.parseInt(str), map.getOrDefault(Integer.parseInt(str), 0) + 1);
                str = "";
            }
        }
        int[] ans = new int[map.size()];
        for (Integer a : map.keySet()) 
            ans[(map.size()-1)-(map.get(a)-1)] = a;
        return ans;
    }
}