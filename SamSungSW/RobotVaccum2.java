import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RobotVaccum2 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        StringTokenizer token = new StringTokenizer(br.readLine());
        int px = Integer.parseInt(token.nextToken());
        int py = Integer.parseInt(token.nextToken());
        int D = Integer.parseInt(token.nextToken());
        for (int i = 0; i < N; i++) {
            StringTokenizer t = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(t.nextToken());
            }
        }
        int ans = 1;
        map[px][py] = 2;
        while (true) {
            int tD = D;
            for (int i = 0; i < 4; i++) {
                tD = (tD + 3) % 4;
                int tx = px + dx[tD];
                int ty = py + dy[tD];
                if (tx > 0 && tx < N - 1 && ty > 0 && ty < M - 1 && map[tx][ty] == 0) {
                    D = tD;
                    px = tx;
                    py = ty;
                    break;
                }
                if (i == 3) {

                    tD = (D + 2) % 4;
                    if (map[px + dx[tD]][py + dy[tD]] == 1 && map[px + dx[(tD + 1) % 4]][py + dy[(tD + 1) % 4]] != 0
                            && map[px + dx[(tD + 2) % 4]][py + dy[(tD + 2) % 4]] != 0
                            && map[px + dx[(tD + 3) % 4]][py + dy[(tD + 3) % 4]] != 0) {
                        System.out.println(ans);
                        return;
                    }
                    px = px + dx[tD];
                    py = py + dy[tD];

                    tD = (D + 2) % 4;
                    i = -1;
                }
            }
            map[px][py] = 2;
            ans++;
        }
    }
}