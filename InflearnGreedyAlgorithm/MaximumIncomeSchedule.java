package InflearnGreedyAlgorithm;

import java.util.*;

public class MaximumIncomeSchedule {
    static class Schedule  {
        int income;
        int date;

        public Schedule(int i, int d) {
            income = i;
            date = d;
        }
       
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Schedule> pq = new PriorityQueue<>(n,(o1, o2) -> {
            if(o2.income==o1.income)
                return o2.date - o1.date;
            return o2.income - o1.income;
        });
        int mD = 0;
        for (int i = 0; i < n; i++) {
            int M = sc.nextInt();
            int D = sc.nextInt();
            Schedule s = new Schedule(M, D);
            pq.add(s);
            mD = Math.max(mD, D);
        }
        for (Schedule s : pq) {
            System.out.println("income:" + s.income + " " + "time: " + s.date);
        }
        System.out.println(solution(pq, mD));
    }

    public static int solution(PriorityQueue<Schedule> pq, int maxD) {
        int answer = 0;
        int[] flag = new int[maxD];
        int len = pq.size();
        for (int i = 0; i < len; i++) {
            Schedule s = pq.poll();
            System.out.println("income test:" + s.income);
            for (int j = s.date - 1; j >= 0; j--) {
                if (j <= s.date && flag[j] == 0) {
                    flag[j] = 1;
                    answer += s.income;
                    break;
                }
            }
        }
        return answer;
    }
}