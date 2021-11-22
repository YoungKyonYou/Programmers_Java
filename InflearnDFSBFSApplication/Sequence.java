package InflearnDFSBFSApplication;
import java.util.*;
public class  Sequence{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] perm = new int[N];
        int[] arr = new int[M];
        int[] flag = new int[12];
        for(int i=0;i<N;i++)
            perm[i] = sc.nextInt();
        solution(perm,arr,flag, 0, M,0);
    }
    public static void solution(int[] perm, int[] arr,int[] flag, int L, int M, int s) {
        if (L == M) {
            for(int a:arr)
                System.out.print(a + " ");
            System.out.println();
        } else {
            for (int i = 0; i < perm.length; i++) {
                if (flag[perm[i]] == 0) {
                    arr[L] = perm[i];
                    flag[perm[i]] = 1;
                    solution(perm, arr, flag, L + 1, M, i + 1);
                    flag[perm[i]] = 0;
                }
            }
        }
    }
}