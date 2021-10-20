
import java.io.BufferedReader;
import java.util.*;

import java.io.InputStreamReader;

public class Resignation {
    static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        dfs(arr, N, 0, 0, 0, N);
        System.out.println(sum);
        
    }

    public static int dfs(int[][] arr, int N, int idx, int cost, int day,int limit) {
        for (int i = idx; i < N; i++) {
            if (day + arr[i][0] <=N && i+arr[i][0]<=limit) {
                int temp = dfs(arr, N, i + arr[i][0], cost+arr[i][1], day + arr[i][0],limit);
                sum = Math.max(temp, sum);
            }
        }
        return cost;
    }
}