import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Laboratory3 {
    private static int map[][] = new int[8][8];
    private static int height, width, answer = 0;
    //북 동 남 서
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    public static void print(int[][] map, int N, int M, int zeros) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //  System.out.println("one:" + cnt);
        // System.out.println("ans:" + zeros);
        System.out.println();

    }
    
    private static void blockArea() {
        int totalArea = height * width;

        for (int first = 0; first < totalArea - 2; first++) {
            if (map[first / width][first % width] == 0) {
                map[first / width][first % width] = 1;
                print(map, height, width, 0);
            } else {
                continue;
            }

            for (int second = first + 1; second < totalArea - 1; second++) {
                if (map[second / width][second % width] == 0) {
                    map[second / width][second % width] = 1;
                    print(map, height, width, 0);
                } else {
                    continue;
                }

                for (int third = second + 1; third < totalArea; third++) {
                    if (map[third / width][third % width] == 0) {
                        map[third / width][third % width] = 1;
                        print(map, height, width, 0);
                    } else {
                        continue;
                    }
                    print(map,height,width,0);

                    updateAnswer();

                    map[third / width][third % width] = 0;
                }
                map[second / width][second % width] = 0;
            }
            map[first / width][first % width] = 0;
        }
    }

    private static void updateAnswer() {
        int result = 0;

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (map[x][y] == 2) {
                    DFS(x, y);
                }
            }
        }

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (map[x][y] == 0) {
                    result++;
                } else if (map[x][y] == 3) {
                    map[x][y] = 0;
                }
            }
        }

        answer = Math.max(answer, result);

    }

    private static void DFS(int x, int y) {
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (isVaildPos(nx, ny) && map[nx][ny] == 0) {
                map[nx][ny] = 3;
                DFS(nx, ny);
            }
        }
    }

    private static boolean isVaildPos(int x, int y) {
        return (x >= 0 && x < height && y >= 0 && y < width);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new int[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        blockArea();

        bw.write(answer + "");
        bw.flush();
        bw.close();

    }

}