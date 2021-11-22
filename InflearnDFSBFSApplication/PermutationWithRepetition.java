package InflearnDFSBFSApplication;
import java.util.*;

public class PermutationWithRepetition {
    static public int[] ans;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ans=new int[M];
        solution(N, M, 0);
    }

    public static void solution(int n, int m, int L) {
        for (int i = 0; i < n; i++) {
            ans[L] = (i + 1);
            if (L == m-1)
                System.out.println(Arrays.toString(ans));
            else
                solution(n, m, L + 1);
        }
    }
}