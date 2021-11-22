package InflearnSorting;

import java.util.*;

public class MischievousBoy {
    public static int[] ans = new int[2];
    public static Scanner sc = new Scanner(System.in);
    public static int[] arr;
    public static int[] temp;
    public static void main(String[] args) throws Exception {
        int N = sc.nextInt();
        arr = new int[N];
        temp = new int[N];
        for (int i = 0; i <N; i++) {
            arr[i] = sc.nextInt();
            temp[i] = arr[i];
        }
        solution(N);
         System.out.println(ans[0]+" "+ans[1]);
    }

    public static void solution(int N) {
        Arrays.sort(arr);
        int idx = 0;
        for (int i = 0; i < N; i++) 
            if(arr[i]!=temp[i])
                ans[idx++] = i+1;
    }
}