package InflearnDFSBFSApplication;
import java.util.*;

public class BaDook2 {
    static public int ans = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] weight = new int[M];
        for(int i=0;i<M;i++)
            weight[i] = sc.nextInt();
        solution(weight, N, 0, 0);
        System.out.println(ans);
    }
    public static void solution(int[] weight, int max, int start, int total) {
        if (total <= max)
            ans = Math.max(ans, total);
        for (int i = start; i < weight.length; i++) 
            solution(weight, max, i+1, total+weight[i]);
    }
}