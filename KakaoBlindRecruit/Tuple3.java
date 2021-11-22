
import java.util.*;
public class Tuple3{
    public static void main(String[] args) throws Exception {
        String str = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        int[] list = solution(str);
        for (int a : list) {
            System.out.print(a + " ");
        }
    }

    public static int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String test = s.replaceAll("[{]", " ").replaceAll("[}]", " ");
        String test2 = test.trim();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b) -> {
            return a.length() - b.length();
        });
        int[] answer = new int[arr.length];
        int idx = 0;
        for (String s1 : arr) {
            for (String s2 : s1.split(",")) {
                if (set.add(s2))
                    answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}