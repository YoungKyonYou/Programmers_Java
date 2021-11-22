
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Laboratory2 {
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int sum = 0;
    static boolean[][] visitF;
    static boolean[][] visitS;
    static boolean[][] visitT;

    public static class Node {
        public int px;
        public int py;

        public Node(int px, int py) {
            this.px = px;
            this.py = py;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visitF = new boolean[N][M];
        visitS = new boolean[N][M];
        visitT = new boolean[N][M];
        int[][] map = new int[N][M];
        int zeros = 0;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                if (map[i][j] == 0) {
                    zeros++;
                }
                if (map[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }

        zeros -= 3;

        dfs(map, 0, N, M, queue, zeros);

        System.out.println(sum);
    }

    public static void dfs(int[][] map,  int cnt, int N, int M, Queue<Node> queue, int zeros) {
        if (cnt == 3) {
            Queue<Node> tempQueue = new LinkedList<>();
            int[][] tempMap = new int[N][M];
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < M; b++) {
                    tempMap[a][b] = map[a][b];
                }
            }
            for (Node node : queue) {
                tempQueue.add(node);
            }
            int tempZeros = zeros;
            int temp = solution(tempQueue, N, M, tempZeros, tempMap);
            sum = Math.max(temp, sum);
            
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(map, cnt + 1, N, M,  queue, zeros);
                    map[i][j] = 0;
                }
            }
        }



    }

    public static void print(int[][] map, int N, int M, int zeros) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                }
            }
        }
        System.out.println("one:" + cnt);
        System.out.println("ans:" + zeros);
        System.out.println();

    }

    public static int solution(Queue<Node> queue, int N, int M, int zeros, int[][] map) {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int xx = node.px + dx[i];
                int yy = node.py + dy[i];
                if (xx >= 0 && xx < N && yy >= 0 && yy < M && map[xx][yy] == 0) {
                    map[xx][yy] = 2;
                    queue.add(new Node(xx, yy));
                    zeros--;
                }
            }
        }
        //print(map, N, M, zeros);
        return zeros;
    }
}