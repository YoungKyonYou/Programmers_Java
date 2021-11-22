package InflearnDFSBFSApplication;
import java.util.*;

public class Tomato {
    static public int[][] box;
    static public Queue<Integer> q;
    static public int[] arrX = { 0, 0, 1, -1 };
    static public int[] arrY = { 1, -1, 0, 0 };
    static public int ans = 0;
    static public int days = 0;
    static public int zeroCnt = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        box = new int[M][N];
        q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) {
                    q.add(i);
                    q.add(j);
                } else if (box[i][j] == 0)
                    zeroCnt++;
            }
        }
        System.out.println(solution(M, N));
    
    }

    public static int solution(int N, int M) {
        if (zeroCnt == 0) 
            return 0;
        while (!q.isEmpty()) {
            int len = q.size() / 2;
            for (int i = 0; i < len; i++) {
                int xx = q.poll();
                int yy = q.poll();
                for (int j = 0; j < 4; j++) {
                    if (xx + arrX[j] >= 0 && xx + arrX[j] < N && yy + arrY[j] >= 0 && yy + arrY[j] < M
                            && box[xx + arrX[j]][yy + arrY[j]] == 0) {
                        box[xx + arrX[j]][yy + arrY[j]] = 1;
                        q.add(xx + arrX[j]);
                        q.add(yy + arrY[j]);
                        ans++;
                    }
                     if(ans==zeroCnt)
                         return days + 1;
                }
            }
            days++;
        }
        return -1;
    }
}