package InflearnDFSBFSApplication;
import java.util.*;

public class CoinChange2 {
    static public int ans = Integer.MAX_VALUE;
    static public int N;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] coins = new int[N];
        for (int i = N-1; i>=0; i--) 
            coins[i] = sc.nextInt();
        int money = sc.nextInt();
        int total = 0;
        int cnt = 0;
        solution(coins, money, total, cnt);
        System.out.println(ans);
    }

    public static void solution(int[] coins, int money, int total, int cnt) {
        for (int i = 0; i < N; i++) {
            if (total <= money && ans > cnt) {
                if (total == money) 
                    ans = Math.min(ans, cnt);
                solution(coins, money, total + coins[i], cnt + 1);
            }   
        }
    }
}