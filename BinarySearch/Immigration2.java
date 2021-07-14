package BinarySearch;

import java.util.*;

public class Immigration2 {
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

            if (sum >= n) {
                // 값 비교
                if (answer > mid)
                    answer = mid;
                // 가능 -> 시간 줄여보기(최대 가능 경우)
                end = mid - 1;
            }
            // 불가능 -> 시간을 더 많이
            else {
                start = mid + 1;
            }
        }

        return answer;
    }

}
