package Arrays;

import java.util.*;

public class GridPlateMaximumSum {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                arr[i][j] = sc.nextInt();
        solution(arr);
    }

    public static void solution(int[][] arr) {
        int max = 0;
        int sumX = 0;
        int sumY = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < arr.length; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
            sumX += arr[i][i];
            sumY += arr[i][(arr.length - 1) - i];
        }
        max = Math.max(max, sumX);
        max = Math.max(max, sumY);
        System.out.println(max);
    }
}
