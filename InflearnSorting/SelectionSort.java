package InflearnSorting;
import java.util.*;

public class SelectionSort {
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        solution(N);
        for(int a:arr)
            System.out.print(a + " ");
    }
    public static void solution(int N) {
        for (int i = 0; i < N-1; i++) {
            int idx = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }
}