import java.util.*;
public class  Mentoring2{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(arr,M,N));
    }

    public static int solution(int[][] arr, int n, int m) {
        int[] flag = new int[arr[0].length+1];
        int ans = 0;
        int f = 0;
        int target;
        for (int k = 1; k <= m; k++) {
            target = k;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (f == 1 && flag[arr[i][j]] == 0) 
                        flag[arr[i][j]] = 1;
                    if (arr[i][j] == target) 
                        f = 1;
                    if (flag[arr[i][j]] == 1 && f == 0) 
                        flag[arr[i][j]] = -1;
                    if (flag[arr[i][j]] == 0) 
                        flag[arr[i][j]] = -1;
                }
                f = 0;
            }

            for (int a : flag) 
                if (a == 1) 
                    ans++;
            Arrays.fill(flag, 0);
        }
        return ans;
    }
}