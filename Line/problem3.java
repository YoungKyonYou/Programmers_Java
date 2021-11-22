package Line;

import java.util.*;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class problem3 {
    static class pairs implements Comparable<pairs> {
        public Integer classification;
        public Integer importance;
        public Integer time;
        public Integer requestTime;

        public pairs(Integer requestTime, Integer time, Integer classification, Integer importance) {
            this.requestTime = requestTime;
            this.time = time;
            this.classification = classification;
            this.importance = importance;
        }

        @Override
        public int compareTo(pairs o) {

            return o.classification.compareTo(this.classification);

        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[][] arr = { { 1, 5, 2, 3 }, { 2, 2, 3, 2 }, { 3, 1, 3, 3 }, { 5, 2, 1, 5 }, { 7, 1, 1, 1 }, { 9, 1, 1, 1 },
                { 10, 2, 2, 9 } };

        int[] ans = solution(arr);
        System.out.println(Arrays.toString(ans));

    }

    static public void print(List<pairs> list) {
        for (pairs p : list) {
            System.out.println(p.time + " " + p.requestTime + " " + p.classification + " " + p.importance);
        }
    }

    public static int[] solution(int[][] jobs) {
        int[] answer = new int[100];
        int idx = 0;
        int time = 1;
        int rank = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<pairs> list = new ArrayList<>();
        list.add(new pairs(jobs[0][0], jobs[0][1], jobs[0][2], jobs[0][3]));
        for (int i = 0; i < jobs.length; i++) {
            pairs p = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            answer[idx++] = p.classification;
            time += p.time;
            for (int j = rank; j <= jobs.length; j++) {
                if (jobs[j][0] <= time) {
                    list.add(new pairs(jobs[j][0], jobs[j][1], jobs[j][2], jobs[j][3]));
                    rank++;
                } else {
                    break;
                }
            }
            print(list);
            System.out.println();
            Collections.sort(list);
            print(list);

            // time += p.time;

        }
        int cnt = 0;
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] != 0)
                cnt++;
        }
        int[] ans = new int[cnt];
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] != 0)
                ans[i] = answer[i];
        }
        return ans;
    }
}