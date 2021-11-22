package InflearnSorting;
import java.util.*;

public class InsertionSort {
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
    public static void solution(int N) {
        for (int i = 0; i < N-1; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}