package InflearnDFSBFSApplication;

import java.util.*;

public class CombinationCases {
    public static int ans = 0;
    public static int[][] arr;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[10000][10000];

        System.out.println(solution(N, M));
    }

    public static int solution(int n, int m) {
        if (n < 0 || m < 0)
            return 0;
        if (arr[n][m]!=0)
            return arr[n][m];
        if (arr[n][m] == 0 && m == 1)
            return arr[n][m] = n;
        else 
            return arr[n][m] = solution(n - 1, m - 1) + solution(n - 1, m);  
    }
}