package InflearnDFSBFSApplication;
import java.util.*;

public class MaximumScore {
    static public int ans = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        solution(arr, M, 0,0,0);
        System.out.println(ans);
    }

    public static void solution(int[][] arr, int max, int totalScore, int totalTime, int start) {
        if (totalTime <= max) 
            ans = Math.max(totalScore, ans);
        for(int i=start;i<arr.length;i++)
            solution(arr,max,totalScore+arr[i][0],totalTime+arr[i][1],i+1);
    }
}