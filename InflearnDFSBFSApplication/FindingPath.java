package InflearnDFSBFSApplication;
import java.util.*;

public class FindingPath {
    static public int answer = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] flag = new int[N + 1];
        int[][] arr = new int[M + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            arr[row][col] = 1;
        }
        flag[1] = 1;
        dfs(flag, arr, 1, 5);
        System.out.println(answer);
    }

    public static void dfs(int[] flag, int[][] arr, int start, int end) {
        if (start == end) {
            System.out.println(Arrays.toString(flag));
            answer++;
        }

        for (int i = 1; i <arr[start].length; i++) {
            if (arr[start][i]==1 && flag[i] == 0) {
                flag[i]=1;
                dfs(flag, arr, i, end);
                flag[i] = 0;
            }
        }
    }
}