package InflearnDynamicProgramming;
import java.util.*;

public class StairClimb2 {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
    public static int solution(int n) {
        int[] dy=new int[n+1];
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] += (dy[i - 2] + dy[i - 1]);
        }
        return dy[n];
    }
}