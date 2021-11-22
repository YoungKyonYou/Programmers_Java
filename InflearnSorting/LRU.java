package InflearnSorting;

import java.util.*;

public class LRU {
    public static int[] arr;
    public static int[] cache;
    public static int flag;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[M];
        cache = new int[N];
        for (int i = 0; i < M; i++)
            arr[i] = sc.nextInt();
        solution(N, M);
        for (int a : cache)
            System.out.print(a + " ");
    }

    public static void swap(int a, int b) {
        int temp = cache[a];
        cache[a] = cache[b];
        cache[b] = temp;
    }

    public static void push(int a) {
        for (int i = a;i>=1;i--)
            swap(i,i-1);
    }
    public static void solution(int N, int M) {
        for (int i = 0; i < M; i++) {
            flag = 0;
            for (int j = 0; j < N; j++) {
                if (cache[j] == 0) {
                    push(j);
                    cache[0] = arr[i];
                    flag = 1;
                    break;
                }
                if (cache[j] == arr[i]) {
                    push(j);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                flag = 1;
                push(N - 1);
                cache[0] = arr[i];
            }
        }
    }
}