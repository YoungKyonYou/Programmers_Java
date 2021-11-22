
import java.util.*;

public class FailPercentage {
    public static class percentage {
        public Integer stage;
        public Integer count;
        public Double per;
        public percentage(Integer stage, Integer count, Double per) {
            this.stage = stage;
            this.count = count;
            this.per = per;
        }

    }

    public static void main(String[] args) throws Exception {
        int[] arr = { 2, 1, 2, 4, 2, 4, 3, 3};
        int N = 5;
        List<Integer> list = solution(N, arr);
        for (int a : list) {
            System.out.print(a + " ");
        }

    }

    public static List<Integer> solution(int N, int[] stages) {
        List<Integer> ans = new ArrayList<>();
        List<percentage> classList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int total = stages.length;
        for (int i = 1; i <= N; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] <= N) {
                map.put(stages[i], map.getOrDefault(stages[i], 0) + 1);
            }
        }
        for (Integer a : map.keySet()) {
            Double d = Double.valueOf((double) map.get(a) / (double) total);
            if (map.get(a) == 0) {
                d = Double.valueOf(0);
            }
            total -= map.get(a);
            classList.add(new percentage(a, map.get(a), d));
        }
        Collections.sort(classList,(o1, o2)->{
            if (Double.compare(o1.per, o2.per) == 0) {
                return o1.per.compareTo(o2.per);
            }
            return o2.per.compareTo(o1.per);
        });
        for (int i = 0; i < classList.size(); i++) {
            ans.add(classList.get(i).stage);
        }
        return ans;
    }
}