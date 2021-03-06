package InflearnDynamicProgramming;

import java.util.*;
public class CrossingStoneBridge {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int[] dy = new int[n + 2];
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n+1; i++) {
            dy[i] += (dy[i - 2] + dy[i - 1]);
        }
        return dy[n+1];
    }
}
