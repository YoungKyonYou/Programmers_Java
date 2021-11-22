package InflearnDFSBFSApplication;

import java.util.*;

public class SequencePrediction {
    static public int cnt = 1;
    static public int f = 0;
    static public int[] flag;
    static public int[] comb;
    static public int[] perm;
    static public int[][] arr;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        flag = new int[N + 1];
        perm = new int[N];
        comb = new int[N];
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            comb[i] = combination(N - 1, i);
        }
        solution(0, N, M, 0);
    }

    public static int combination(int a, int b) {
        if (arr[a][b] != 0)
            return arr[a][b];
        if (a == b || b == 0)
            return 1;
        else {
            return arr[a][b] = combination(a - 1, b - 1) + combination(a - 1, b);
        }
    }

    public static void solution(int L, int N, int M, int sum) {
        if (f == 1)
            return;
        if (L == N) {
            if (sum == M) {
                f = 1;
                for (int a : perm)
                    System.out.print(a + " ");
                System.out.println();
                return;
            }
        } else {
            for (int i = 1; i <= N; i++) {
                if (flag[i] == 0) {
                    flag[i] = 1;
                    perm[L] = i;
                    solution(L + 1, N, M, sum + (perm[L] * comb[L]));
                    flag[i] = 0;
                }
            }
        }
    }
}