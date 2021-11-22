package InflearnDynamicProgramming;

import java.util.*;
import java.io.*;
public class  LIS{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) 
            arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int answer = 0;
        int[] dy = new int[arr.length];
        dy[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int temp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > temp)
                    temp=dy[j];
                dy[i] = 1 + temp;
                answer = Math.max(answer, dy[i]);
            }
        }
        return answer;
    }
}