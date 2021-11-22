package InflearnSorting;

import java.util.*;

public class LRU2 {
    public static int[] arr;
    public static LinkedList<Integer> cache=new LinkedList<>();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[M];
        for (int i = 0; i < M; i++)
            arr[i] = sc.nextInt();
        solution(N, M);
        for (int a : cache)
            System.out.print(a + " ");
    }
    public static void solution(int N, int M) {
        for (int i = 0; i < M; i++) {
            if (cache.contains(arr[i])) {
                Integer t = arr[i];
                cache.remove(t);
                cache.addFirst(arr[i]);
            } else if (cache.size() < N)
                cache.addFirst(arr[i]);
            else{
                cache.removeLast();
                cache.addFirst(arr[i]);
            }
        }
    }
}