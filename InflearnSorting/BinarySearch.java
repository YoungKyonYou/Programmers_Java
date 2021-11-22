package InflearnSorting;
import java.util.*;

public class BinarySearch {
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        System.out.println(solution(N, M));
    }

    public static int solution(int N, int M) {
        int start = 0;
        int end = N - 1;
        while (start <=end) {
            int mid = (start + end) / 2;
            if(M==arr[mid])
                return mid + 1;
            if (arr[mid] > M) {
                end = mid-1;   
            } else {
                start = mid+1;
            }
        }
        return 0;
    }
}