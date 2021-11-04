package InflearnDFSBFSApplication;
import java.util.*;

public class CoinChange {
    static public int ans = Integer.MAX_VALUE;
    static public int[] flag;
    static public int N;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) 
            coins[i] = sc.nextInt();
        int money = sc.nextInt();
        flag = new int[money+1];
        solution(coins, money);
        System.out.println(ans);
    }

    public static int solution(int[] coins, int money) {
        Queue<Integer> q = new LinkedList<>();
        int L = 0;
        q.add(0);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int j = 0; j < len; j++) {
                int a = q.poll();
                for (int i = 0; i < N; i++) {
                    if (a + coins[i] <= money && flag[a + coins[i]] == 0) {
                        flag[a + coins[i]] = 1;
                        q.add(a + coins[i]);
                    }
                    if (a + coins[i] == money)
                        ans = Math.min(ans, L + 1);
                }
            }
            L++;
        }
        return ans;
    }
}