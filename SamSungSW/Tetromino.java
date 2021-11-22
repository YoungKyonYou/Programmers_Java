
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Tetromino {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int sum = 0;

    public static void main(String[] args) throws Exception {
        Integer test = 4;
        Integer test2 = test;
        test2 = 3;
        System.out.println("test:" + test + " test2:" + test2);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        boolean[][] visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        int temp = 0;
        int ans = 0;
        int fans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans += arr[i][j];
                visit[i][j] = true;
                temp = dfs(i, j, arr, 1, N, M, visit, ans,i,j);
                fans = Math.max(fans, temp);
                ans = 0;
                visit[i][j] = false;
            }
        }
        System.out.println(temp);
    }

    public static void print(boolean[][] flag, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(flag[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int dfs(int x, int y, int[][] arr, int cnt, int N, int M, boolean[][] visit, int ans, int preX, int preY) {
        if (cnt == 4) {
            return ans;
        }
        if (cnt == 3) {
            for (int j = 0; j < 4; j++) {
                int ppx =preX + dx[j];
                int ppy = preY + dy[j];
                if (ppx >= 0 && ppx < N && ppy >= 0 && ppy < M && !visit[ppx][ppy]) {

                    visit[ppx][ppy] = true;
                    ans += arr[ppx][ppy];
                    int tempp = dfs(ppx, ppy, arr, cnt + 1, N, M, visit, ans,preX,preY);
                    if (tempp == 20) {
                        print(visit, N, M);
                    }
                    ans -= arr[ppx][ppy];
                    visit[ppx][ppy] = false;
                    sum = Math.max(sum, tempp);
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            int px = x + dx[i];
            int py = y + dy[i];
            if (px >= 0 && px < N && py >= 0 && py < M) {
                
                if (!visit[px][py]) {
                    visit[px][py] = true;
                    ans += arr[px][py];
                
                    int temp = dfs(px, py, arr, cnt + 1, N, M, visit, ans,x,y);
                    
                    
                    ans -= arr[px][py];
                    visit[px][py] = false;
                    sum = Math.max(sum, temp);

                }
            }
        }
        return sum;
    }
}