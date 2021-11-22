package InflearnSorting;
import java.util.*;

public class MusicVideo {
    public static int a = Integer.MAX_VALUE;
    public static int[] arr;
    public static int t;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) 
            arr[i] = sc.nextInt();
        solution(N, M);
        System.out.println(a);
    }
    public static void solution(int N, int M) {
        int start = arr[N - 1];
        //int start=Arrays.stream(arr).max().getAsint();
        int end = Arrays.stream(arr).sum();
        while (start <= end) {
            int mid = (start + end) / 2;
            int total = 0;
            int cnt = 0;
            int tans = -1;
            for (int i = 0; i < N; i++) {
                if (total+arr[i] > mid) {
                    cnt++;
                    total = 0;
                }
                total += arr[i];
                tans = Math.max(tans, total);
            }
            if (cnt+1 <= M) {
                a = Math.min(a, tans);
                end = mid - 1;  
            } else if (cnt + 1 > M) 
                start = mid + 1;
            tans = -1;
        }
    }
}