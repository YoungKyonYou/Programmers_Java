import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MarbleEscape3 {

    static int N, M; // N 세로, M 가로
    static int[] dirx = { -1, 0, 1, 0 };
    static int[] diry = { 0, -1, 0, 1 };
    static char map[][];

    static boolean[][][][] visit;

    static Queue<Node> queue = new LinkedList<Node>();

    public static void printB(char[][] arr, int M, int N, int x, int y) {

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == x && j == y) {
                    System.out.print("B");
                } else
                    System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

    }
    
    public static void printR(char[][] arr, int M, int N, int x, int y) {

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == x && j == y) {
                    System.out.print("R");
                } else
                    System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

    }
    public static void main(String[] args) throws Exception {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        visit = new boolean[M][N][M][N];

        Node initNode = new Node(0, 0, 0, 0, 0);

        for (int n = 0; n < N; n++) {
            String token = br.readLine();
            for (int m = 0; m < M; m++) {
                char tmp = token.charAt(m);
                map[m][n] = tmp;
                if (tmp == 'R') {
                    initNode.rx = m;
                    initNode.ry = n;
                }
                if (tmp == 'B') {
                    initNode.bx = m;
                    initNode.by = n;
                }
            }
        }
        

        queue.offer(initNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            visit[node.rx][node.ry][node.bx][node.by] = true;

            if (node.count >= 10) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int bx = node.bx;
                int by = node.by;
                int rx = node.rx;
                int ry = node.ry;
                // 파란색 구슬부터 굴림.
                while (map[bx + dirx[i]][by + diry[i]] != '#') {
                    bx += dirx[i];
                    by += diry[i];
                    if (map[bx][by] == 'O')
                        break;
                    printB(map, M, N,bx,by);
                }
                

                if (map[bx][by] == 'O')
                    continue;

                while (map[rx + dirx[i]][ry + diry[i]] != '#') {
                    rx += dirx[i];
                    ry += diry[i];
                    if (map[rx][ry] == 'O')
                        break;
                    printR(map, M, N,rx, ry);
                }

                if (map[rx][ry] == 'O') {
                    System.out.println(node.count + 1);
                    return;
                }

                // 겹치는 경우 처리
                if (bx == rx && by == ry) {
                    switch (i) {
                        case 0:
                            if (node.bx > node.rx) {
                                bx += 1;
                            } else
                                rx += 1;
                            break;
                        case 1:
                            if (node.by > node.ry) {
                                by += 1;
                            } else
                                ry += 1;
                            break;
                        case 2:
                            if (node.bx > node.rx) {
                                rx -= 1;
                            } else
                                bx -= 1;
                            break;
                        case 3:
                            if (node.by > node.ry) {
                                ry -= 1;
                            } else
                                by -= 1;
                            break;
                    }
                }
              

                if (!visit[rx][ry][bx][by]) {
                    queue.offer(new Node(rx, ry, bx, by, node.count + 1));
                }
            }
        }
        System.out.println(-1);
    }
}

class Node {
    public int rx;
    public int ry;
    public int bx;
    public int by;
    public int count;

    public Node() {
    }

    public Node(int rx, int ry, int bx, int by, int count) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.count = count;
    }
}
