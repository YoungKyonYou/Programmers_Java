package TwoPointer;
import java.util.*;
public class  MerginTwoArrays{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1=new int[N];
        for(int i=0;i<N;i++)
            arr1[i] = sc.nextInt();
        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for(int i=0;i<M;i++)
            arr2[i] = sc.nextInt();
        solution(arr1,arr2,N,M);
    }

    public static void solution(int[] arr1, int[] arr2, int N, int M) {
        int idx1=0;
        int idx2=0;
        for (int i = 0; i < N + M; i++) {
            int a1=Integer.MAX_VALUE, a2=Integer.MAX_VALUE;
            if(idx1<N)
                a1 = arr1[idx1];
            if(idx2<M)
                a2 = arr2[idx2];
            if (a1 < a2) {
                System.out.print(a1 + " ");
                idx1++;
            } else {
                System.out.print(a2 + " ");
                idx2++;
            }
        }
    }
}