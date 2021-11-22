package InflearnSorting;
import java.util.*;

public class StablingHorses {
    public static int[] arr;
    public static int ans = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        solution(M);
        System.out.println(ans);
    }

    public static void solution(int M) {
        int start = 1;
        int end = arr[arr.length - 1] - arr[0];
        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt=1;
            int total=arr[0];
            for (int i = 1; i < arr.length ; i++) {
                if (arr[i]-total >= mid) {
                    total = arr[i];
                    cnt++;
                }
            }
            if (cnt >= M) {
                start = mid + 1;
                ans = mid;
            } else 
                end = mid - 1;
        }
    }
}