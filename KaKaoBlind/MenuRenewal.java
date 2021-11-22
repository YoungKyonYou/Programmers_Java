
import java.util.*;

public class MenuRenewal {
    static List<String> comb = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();



    public static void main(String[] args) throws Exception {
        String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
        int[] result = { 2,3,4 };
        solution(orders, result);
    }

    public static void dfs(int L, int m,int s,String str,String[] one) {
        if (L == m) {
            comb.add(str);
        }else{
            for (int i = s; i <one.length; i++) {
                dfs(L + 1, m, i + 1, str+one[i], one);
            }
        }
    }

    public static List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            String[] one = orders[i].split("");
            Arrays.sort(one);
            String str = "";
            for (int k = 0; k < course.length; k++) {
                dfs(0, course[k], 0, str, one);
            }
        }
        
        for (String s : comb) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(o1,o2)->{
            return map.get(o2)-map.get(o1);
        });

        for (int i = 0; i < course.length; i++) {
            int max = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).length() == course[i])
                    max = Math.max(max, map.get(list.get(j)));
                if (map.get(list.get(j)) >= 2 && list.get(j).length() == course[i] && map.get(list.get(j)) == max) {
                    answer.add(list.get(j));
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}