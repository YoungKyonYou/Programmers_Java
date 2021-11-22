package InflearnSorting;
import java.util.*;

public class BubbleSort {
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        solution(N);
        for (int a : arr)
            System.out.print(a + " ");
    }

    public static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void solution(int N) {
        int i, j;
        for (i = 0; i < N; i++)
            for (j = 0; j < N - i-1; j++)
                if (arr[j] > arr[j+1])
                    swap(j, j+1);
    }
}