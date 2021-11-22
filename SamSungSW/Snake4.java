import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 3190. 뱀
 */

class Snake4 {

    static int[] ci = { 0, 1, 0, -1 };
    static int[] cj = { 1, 0, -1, 0 };
    
    public static class Snake {
        int i;
        int j;
        int pIdx;

        public Snake(int i, int j, int pIdx) {
            this.i = i;
            this.j = j;
            this.pIdx = pIdx;
        }
    }


    public static void main(String[] args) throws Exception {
        Snake[] snake = new Snake[200];
        int[] direction = new int[10001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[T][T];
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken())-1;
            int y = Integer.parseInt(token.nextToken())-1;
            map[x][y] = 2;
        }
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            direction[Integer.parseInt(token.nextToken())] = token.nextToken().charAt(0);
        }
        map[0][0] = 1;
        int len=0;
        int headIdx=0;
        int tailIdx=0;
        int dx=0;
        int ans=0;
        int d=0;
        int dy=0;
        snake[len++] = new Snake(0, 0,-1);
        while (true) {
            dx+=ci[d];
            dy += cj[d];
            if (dx < 0 || dx >= T || dy < 0 || dy >= T) {
                System.out.println(ans+1);
                return;
            } else if (map[dx][dy] == 2) {
                snake[len++] = new Snake(dx, dy, -1);
                snake[headIdx].pIdx = len - 1;
                
               headIdx = len - 1;
               map[dx][dy] = 1;
                
            } else if (map[dx][dy] == 0) {
                map[dx][dy] = 1;
                map[snake[tailIdx].i][snake[tailIdx].j] = 0;



                snake[headIdx].pIdx = tailIdx;
                headIdx = tailIdx;
                
                tailIdx=snake[tailIdx].pIdx;
                snake[headIdx].pIdx=-1;


                snake[headIdx].i = dx;
                snake[headIdx].j = dy;
            } else if (map[dx][dy] == 1) {
                System.out.println(ans+1);
                return;
            }
            ans++;
            if (direction[ans] == 'D') {
                d = (d + 1) % 4;
            } else if (direction[ans] == 'L') {
                d = (d + 3) % 4;
            }
        }
    }
}
