import java.util.*;

public class DistanceConfirmation3 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static boolean[][] visit;

    static int[] answer;
    public static void main(String[] args) throws Exception {
        String[][] arr = { { "POOOP", "OXXOX", "OPXPX", "OOXOX",
                "POXXP" },
                { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
                { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
        int[] ans = solution(arr);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }
    
    public static void dfs(int num,int x, int y, int count, String[] places) {
        if (count > 2) {
            return;
        }
        if (count > 0 && count <= 2 && places[x].charAt(y) == 'P') {
            answer[num] = 0;
            return;
        }
        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];
            if (xx >= 0 && xx < 5 && yy >= 0 && yy < 5 && places[xx].charAt(yy) != 'X' &&!visit[xx][yy]) {
                visit[xx][yy] = true;
                dfs(num, xx, yy, count + 1, places);
                visit[xx][yy] = false;
            }
        }
    }

    public static int[] solution(String[][] places) {
        answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            answer[i] = 1;
        }

        for (int i = 0; i < places.length; i++) {
            visit = new boolean[5][5];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        visit[j][k] = true;
                        dfs(i, j, k, 0, places[i]);
                        visit[j][k] = false;
                    }
                }
            }
        }
        return answer;
    }
}