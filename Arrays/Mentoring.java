package Arrays;
import java.util.*;
public class  Mentoring{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                arr[i][j] = sc.nextInt();
        }
        System.out.println(solution(arr, N,M));
    }

    public static int solution(int[][] arr, int n, int m) {
        int ans = 0;
        int cmp = 0;
        int flag = 0;
        for (int i = 0; i < m; i++) {
            int init = arr[0][i];
            for (int j = i+1; j < n; j++) {
                
                for (int k = 1; k < m; k++) {
                    flag = 0;
                    for (int r = 0; r < n; r++) {
                        if (init == arr[k][r]) {
                            flag = 1;
                        }
                        if (flag == 1 && arr[k][r] == arr[i][j]) {
                            ans++;
                            flag = 0;
                        }
                    }
                    if(flag==1)
                        break;

                }
            }
            
        }
        return ans;
    }
}