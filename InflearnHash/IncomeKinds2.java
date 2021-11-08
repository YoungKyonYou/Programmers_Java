package InflearnHash;

import java.util.*;

public class IncomeKinds2 {
    public static int[] arr;
    public static int[] ans;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N];
        ans = new int[N - M + 1];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        solution(M);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

    public static void solution(int M) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int idx = 0;
        int lt=0, rt = M - 1;
        for (int i = 0; i < arr.length; i++) {
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
            if (i > M - 1) {
                hash.put(arr[lt], hash.getOrDefault(arr[lt], 0) - 1);
                if (hash.get(arr[lt]) == 0) 
                    hash.remove(arr[lt]);
                lt++;
            }
            if (i >=M - 1) 
                ans[idx++] = hash.size();
        }
    }
}