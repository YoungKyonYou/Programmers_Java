package BinarySearch;

import java.util.*;

public class Immigration {
    public static void main(String[] args) throws Exception {
        int n = 6;
        int[] times = { 7, 10 };
        long a = solution(n, times);
        System.out.println("answer:" + a);
    }

    public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long start = 0, mid, end = Long.MAX_VALUE, sum;
        while (start <= end) {
            sum = 0;
            mid = (start + end) / 2;

            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
                if (sum >= n)
                     break;
            }

            if (sum<n) {
                start = mid + 1;

            } else {
                end = mid - 1;
                answer = mid;
            } 

        }

        return answer;
    }

}
