package InflearnHash;

import java.util.*;

public class KthBiggestNumber {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        System.out.println(solution(N, M, arr));
    }

    public static int solution(int N, int M, int[] arr) {
        int ans = 0;
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < N - 2; i++)
            for (int j = (i + 1); j < N - 1; j++)
                for (int k = (j + 1); k < N; k++)
                    set.add(arr[i] + arr[j] + arr[k]);
        int cnt = 0;
        for (int a : set) {
            cnt++;
            if (cnt == M) {
                ans = a;
                break;
            }
        }
        return ans != 0 ? ans : -1;
    }
}