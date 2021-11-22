import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 3190. 뱀
 */

class Snake3 {
    static final int INF = 987654321;
    static int max;
    static int N;
    
    static int[] ci = { 0, 1, 0, -1 };
    static int[] cj = { 1, 0, -1, 0 };
    
    public static class Snake {
        int i;
        int j;
        int pIdx;

        public Snake() {
        }

        public Snake(int i, int j, int pIdx) {
            this.i = i;
            this.j = j;
            this.pIdx = pIdx;
        }
    }
    
    public static void print(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void main(String[] args) throws Exception {
        Snake[] snake = new Snake[11];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        int len = 0;
        int headIdx = 0;
        int tailIdx = 0;
        snake[0] = new Snake(0, 0, -1);
        board[0][0] = 1;

        for (int i = 0; i < K; i++) {
            String[] data = br.readLine().split(" ");
            board[Integer.parseInt(data[0]) - 1][Integer.parseInt(data[1]) - 1] = 2;
        }
        int L = Integer.parseInt(br.readLine());
        char C[] = new char[10001];
        for (int i = 0; i < L; i++) {
            String[] data = br.readLine().split(" ");
            C[Integer.parseInt(data[0])] = data[1].charAt(0);
        }

        int time = 0;
        int dir = 0;
        int nextI = 0;
        int nextJ = 0;
        while (true) {
            time++;
            nextI += ci[dir];
            nextJ += cj[dir];
            //범위 검사, 벽 만나면 break;
            if (nextI >= N || nextI < 0 || nextJ >= N || nextJ < 0)
                break;
            //자기 꼬리를 물면 break;
            if (board[nextI][nextJ] == 1)
                break;
            // 사과일 경우
            if (board[nextI][nextJ] == 2) {
                snake[++len] = new Snake(nextI, nextJ, -1);
                snake[headIdx].pIdx = len;
                headIdx = len;
                board[nextI][nextJ] = 1;
                //사과가 없다면
            } else {
            //제일 끝 꼬리부분 없애기
                board[snake[tailIdx].i][snake[tailIdx].j] = 0;
                snake[headIdx].pIdx = tailIdx;
                
                //여기서 headIdx=tailIdx하는 이유는 링키드 리스트에서 꼬리가 머리를 가리키는 형태 즉 원형 리스트를 생각하면 된다.
                headIdx = tailIdx;
                //tailIdx을 바로 앞으로 옮긴다.
                //즉 움직였으니까 마지막 꼬리 부분 가리키다가 앞 쪽 가리키는 것
                if (snake[tailIdx].pIdx != -1)
                    tailIdx = snake[tailIdx].pIdx;
                //다음칸 이동
                snake[headIdx].i = nextI;
                snake[headIdx].j = nextJ;
                snake[headIdx].pIdx = -1;
                board[nextI][nextJ] = 1;
                }
            print(board);
        
            if (C[time] == 'L') {
                dir = (dir + 3) % 4;
            } else if (C[time] == 'D') {
                dir = (dir + 1) % 4;
            }
        }
        System.out.println(time);
    }
}

