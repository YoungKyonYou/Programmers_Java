package InflearnDynamicProgramming;

import java.util.*;
import java.io.*;

public class ChangingMoney {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            coins[i] = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(br.readLine());
        int[] arr = new int[money + 1];
        System.out.println(solution(arr, coins));
    }

    public static int solution(int[] arr, int[] coins) {
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j < arr.length; j++)
                if (arr[j - coins[i]] < arr[j])
                    arr[j] = arr[j - coins[i]] + 1;
        return arr[arr.length - 1];
    }
}