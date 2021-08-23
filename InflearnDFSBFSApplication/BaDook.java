package InflearnDFSBFSApplication;
import java.util.*;

public class BaDook {
    static public int[] flag;
    static public int ans = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] weight = new int[M];
        flag = new int[M];
        for(int i=0;i<M;i++)
            weight[i] = sc.nextInt();
        solution(weight, N, 0, 0);
        System.out.println(ans);
    }

    public static void solution(int[] weight, int max, int start, int total) {
        if (total <= max)
            ans = Math.max(ans, total);
        for (int i = start; i < weight.length; i++) {
            if (flag[i] == 0) {
                flag[i] = 1;
                solution(weight, max, i, total+weight[i]);
                flag[i] = 0;
            }
        }
    }
}