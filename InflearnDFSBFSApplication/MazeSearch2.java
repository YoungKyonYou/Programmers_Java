package InflearnDFSBFSApplication;
import java.util.*;

public class MazeSearch2 {
    public static int[][] map = new int[7][7];
    public static int ans = 0;
    public static int[] arrX={0,0,1,-1};
    public static int[] arrY = { 1, -1, 0, 0 };
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 7; i++) 
            for (int j = 0; j < 7; j++) 
                map[i][j] = sc.nextInt();
        map[0][0] = 1;
        System.out.println(solution(0, 0));
    }
    public static int solution(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        while (!q.isEmpty()) {
            int len = q.size()/2;
            for (int i = 0; i < len; i++) {
                int xx = q.poll();
                int yy = q.poll();
                for (int j = 0; j < 4; j++) {
                    if (xx + arrX[j] < 7 && yy + arrY[j] < 7 && xx + arrX[j] >=0 && yy + arrY[j] >=0) {
                        if (map[xx + arrX[j]][yy + arrY[j]] == 0) {
                            if (xx+arrX[j] == 6 && yy+arrY[j] == 6)
                                return ans+1;
                            map[xx + arrX[j]][yy + arrY[j]] = 3;
                            q.add(xx + arrX[j]);
                            q.add(yy + arrY[j]);   
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}